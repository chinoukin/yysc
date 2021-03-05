package com.wisea.yysc.tp.system.service.system;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.UpdatePasswordUserPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.PasswordUtil;

import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.MembInfoGetPo;
import com.wisea.yysc.common.po.memb.*;
import com.wisea.yysc.common.vo.memb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 后台会员相关的接口相关的Service
 */
@Service
public class MembBackMageService extends BaseService {
	
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private RemoteUserMss remoteUserMss;

	/**
	 * 根据id获取会员的基本信息
	 * 
	 * @author wangh(wisea)
	 *
	 * @date 2018年10月13日
	 * @version 1.0
	 */
	public ResultPoJo<MembBaseDetailVo> getMembBaseInfo(MembInfoGetPo po){
		//  返回参数
		ResultPoJo<MembBaseDetailVo> result = new ResultPoJo<MembBaseDetailVo>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		MembBaseDetailVo vo = membInfoMapper.getMembBaseDetail(po.getId());
		result.setResult(vo  );
		return result;
	}

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
	 * 保存会员头像信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月29日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveMembUrl(StringPo po){
		// 返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		//保存会员表中的信息-头像
		MembInfo membInfo = new MembInfo();
		membInfo.setId(user.getId());
		membInfo.setLogoUrl(po.getKeyStr());
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		return result;
	}
}
