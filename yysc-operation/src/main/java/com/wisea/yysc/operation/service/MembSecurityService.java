package com.wisea.yysc.operation.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.UpdatePasswordUserPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sms.SmsService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.PasswordUtil;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.memb.MembPwdUpdatePo;
import com.wisea.yysc.common.po.memb.MobileUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class MembSecurityService extends BaseService {


    @Autowired
    private SmsService smsService;

    @Autowired
    protected MembInfoMapper membInfoMapper;

    @Autowired
    private RemoteUserMss remoteUserMss;

    /**
     * 通过旧密码修改用户密码(修改当前用户的密码)
     *
     * @author wangh(wisea)
     *
     * @date 2018年9月26日
     * @version 1.0
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> userUpdPwd(MembPwdUpdatePo membPwdUpdatePo){
        //  返回参数
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 验证登录用户的信息
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        // 验证密码和确认密码是否相同
        if(!membPwdUpdatePo.getNewPwd().equals(membPwdUpdatePo.getConNewPwd())){
            result.setCode(ConstantCodeMsg.ERR_504);
            result.setMsg(ConstantCodeMsg.MSG_504);
            return result;
        }
        // 校验旧密码是否正确
        if (!PasswordUtil.validatePassword(membPwdUpdatePo.getOldPwd(),user.getPassword())) {
            result.setCode(ConstantError.ERR_906);
            result.setMsg(ConstantError.MSG_906);
            return result;
        }
        // 调用修改用户密码的接口
        // 修改用户的密码
        UpdatePasswordUserPo updatePasswordUserPo = new UpdatePasswordUserPo();
        updatePasswordUserPo.setId(user.getId());
        updatePasswordUserPo.setPassword(membPwdUpdatePo.getOldPwd());
        updatePasswordUserPo.setNewPassword(membPwdUpdatePo.getConNewPwd());
        ResultPoJo<Object> userResult = remoteUserMss.updatePassword(updatePasswordUserPo);
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            checkRemoteResult(userResult);
            return result;
        }
        return result;
    }

    /**
     * 修改手机号
     * @param mobileUpdatePo 验证信息
     */
    @Transactional
    public ResultPoJo<Object> updateMobile(MobileUpdatePo mobileUpdatePo) {
        //  返回参数
        ResultPoJo<Object> result = new ResultPoJo<Object>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        String mobile = user.getMobile();
        //验证原来用户是否存在手机号
        if (ConverterUtil.isEmpty(mobile)) {
            result.setCode(ConstantCodeMsg.ERR_528);
            result.setMsg(ConstantCodeMsg.MSG_528);
        }
        //验证是否号是否一致
        if (!Objects.equals(mobile, mobileUpdatePo.getRegisteredMobile())) {
            result.setCode(ConstantCodeMsg.ERR_812);
            result.setMsg(ConstantCodeMsg.MSG_812);
        }
        //验证验证码
        Boolean smsCode = smsService.checkSMSCode(mobileUpdatePo.getRegisteredMobile(), mobileUpdatePo.getValCode());
        if (!smsCode) {
            //验证码不正确
            result.setCode(ConstantCodeMsg.ERR_503);
            result.setMsg(ConstantCodeMsg.MSG_503);
        }
        // 设置手机号
        String newMobile = mobileUpdatePo.getNewMobile();
        user.setMobile(newMobile);
        user.setCurrentUser(user);
        user.preUpdate();
        remoteUserMss.mobileUpdate(user);

        // 更新memb_info表用户手机号
        MembInfo membInfo = new MembInfo();
        membInfo.setId(user.getId());
        membInfo.setRegistTel(newMobile);
        membInfoMapper.updateByPrimaryKeySelective(membInfo);
        return result;
    }
}
