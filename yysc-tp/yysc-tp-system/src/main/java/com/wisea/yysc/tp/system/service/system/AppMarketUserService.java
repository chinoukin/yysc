package com.wisea.yysc.tp.system.service.system;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;

import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.dao.OrderInfosMapper;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.AppMarketUserPagePo;
import com.wisea.yysc.common.po.FindMembInfoPo;
import com.wisea.yysc.common.po.FreezeMembUpdPo;
import com.wisea.yysc.common.po.memb.MembCheckMobilePo;
import com.wisea.yysc.common.po.memb.MembMobileUpdPo;
import com.wisea.yysc.common.po.memb.SubAcctInfoGetPo;
import com.wisea.yysc.common.vo.AppMarketUserListVo;
import com.wisea.yysc.common.vo.FindMembInfoPageVo;
import com.wisea.yysc.common.vo.FindMembInfoVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *应用市场用户管理
 */
@Service
public class AppMarketUserService extends BaseService {

    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private RemoteUserMss remoteUserMss;
    @Autowired
    private OrderInfosMapper orderInfosMapper;

    /**
     * 分页查询应用市场用户列表信息
     * @param po
     * @return
     */
    public ResultPoJo<Page<AppMarketUserListVo>> findPage(AppMarketUserPagePo po) {
        ResultPoJo<Page<AppMarketUserListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<AppMarketUserListVo> page = po.getPage();
        List<AppMarketUserListVo> list = membInfoMapper.findAppMarketUserPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 导出应用市场用户列表信息
     * @param po
     * @return
     */
    public  List<AppMarketUserListVo> findListExport(AppMarketUserPagePo po) {
        List<AppMarketUserListVo> list = membInfoMapper.findAppMarketUserPageList(po);
        for (AppMarketUserListVo  val:list){
            // 正常
            if(DictConstants.ACCT_STATE_0.equals(val.getAcctState())){
                val.setAcctState("正常");
            }else if(DictConstants.ACCT_STATE_1.equals(val.getAcctState())){
                val.setAcctState("冻结");
                // 冻结
            }

        }
        return list;
    }

//    @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo<String> freezeMemb(FreezeMembUpdPo po){
        // 返回参数定义
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 验证登录用户的信息
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        // 验证参数是否真实存在
        MembInfo exist = membInfoMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isEmpty(exist)){
            result.setCode(ConstantCodeMsg.ERR_513);
            result.setMsg(ConstantCodeMsg.MSG_513);
            return result;
        }
        // 用户的处理
        LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
        // 正常
        if(DictConstants.ACCT_STATE_0.equals(po.getAcctState())){
            loginBatUpdate.setLoginFlag(DictConstants.DEFAULT_FLAG_1);
            po.setAcctState(DictConstants.ACCT_STATE_1);
            // 冻结
        }else if(DictConstants.ACCT_STATE_1.equals(po.getAcctState())){
            loginBatUpdate.setLoginFlag(DictConstants.DEFAULT_FLAG_0);
            po.setAcctState(DictConstants.ACCT_STATE_0);
        }
        loginBatUpdate.setIds(ConverterUtil.toString(exist.getId()));
        ResultPoJo<Object> userResult = remoteUserMss.loginBatUpdate(loginBatUpdate);
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            checkRemoteResult(userResult);
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            return result;
        }
        // 保存到表中
        MembInfo info = new MembInfo();
        info.setId(po.getId());
        info.setAcctState(po.getAcctState());
        membInfoMapper.updateByPrimaryKeySelective(info);
        return result;
    }


    /**
     * 后台会员注册手机号的修改
     *
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> updMembMobile(MembMobileUpdPo po){
        // 返回参数定义
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 验证登录用户的信息
        User loginUser = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(loginUser)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        // 验证参数是否真实存在
        MembInfo exist = membInfoMapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isEmpty(exist)){
            result.setCode(ConstantCodeMsg.ERR_513);
            result.setMsg(ConstantCodeMsg.MSG_513);
            return result;
        }
        // 手机号已经存在的情况
        MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
        membCheckMobilePo.setMobile(po.getRegistTel());
        membCheckMobilePo.setMembId(po.getId());
        int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
        if(mobileCount > 0){
            result.setCode(ConstantCodeMsg.ERR_501);
            result.setMsg(ConstantCodeMsg.MSG_501);
            return result;
        }
        User user = new User();
        user.setId(po.getId());
        user.setMobile(po.getRegistTel());
        ResultPoJo<Object> userResult = remoteUserMss.mobileUpdate(user);
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            checkRemoteResult(userResult);
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            return result;
        }
        // 修改会员表中的信息
        MembInfo membInfo = new MembInfo();
        membInfo.setId(po.getId());
        membInfo.setRegistTel(po.getRegistTel());
        membInfo.preUpdate();
        membInfoMapper.updateByPrimaryKeySelective(membInfo);
//        //清除redis
//        MembUtils.delMembUser(po.getId());
        return result;
    }

    /**
     * 删除用户
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> delMembSub(SubAcctInfoGetPo po){
        //  返回参数
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 验证登录用户的信息
        User user = SystemUtils.getUser();
        if(ConverterUtil.isEmpty(user)){
            result.setCode(ConstantCodeMsg.ERR_912);
            result.setMsg(ConstantCodeMsg.MSG_912);
            return result;
        }
        // 删除用户信息
        ResultPoJo<Object> userResult = remoteUserMss.batDelete(ConverterUtil.toString(po.getId()));
        if(!userResult.getCode().equals(ConstantError.NOMAL)){
            checkRemoteResult(userResult);
            result.setCode(userResult.getCode());
            result.setMsg(userResult.getMsg());
            return result;
        }
        MembInfo membInfo = new MembInfo();
        membInfo.setId(po.getId());
        membInfo.preUpdate();
        membInfoMapper.deleteLogic(membInfo);
//        //清除redis
//        MembUtils.delMembUser(po.getId());
        return result;
    }

    /**
     * 查看详情会员信息
     */
    public ResultPoJo<FindMembInfoVo> findInfo(FindMembInfoPo po){
        ResultPoJo<FindMembInfoVo> result = new ResultPoJo<FindMembInfoVo>(ConstantCodeMsg.NOMAL);
        FindMembInfoVo vo = new FindMembInfoVo();
        //会员信息
        vo = membInfoMapper.findMemberInfo(po.getId());
        // 分页查询列表信息
        Page<FindMembInfoPageVo> page = po.getPage();
        page.setList(orderInfosMapper.findAppList(po));
        vo.setPageList(page);
        result.setResult(vo);
        return result;
    }

}
