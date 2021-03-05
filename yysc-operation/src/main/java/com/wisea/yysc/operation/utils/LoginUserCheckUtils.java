package com.wisea.yysc.operation.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.dao.OrderInfosMapper;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.memb.CheckValidPo;
import com.wisea.yysc.common.po.memb.LoginNameOrMobilePo;
import com.wisea.yysc.common.po.memb.MembCheckLoginNamePo;
import com.wisea.yysc.common.vo.memb.CheckValidVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

/**
 * 登录相关验证的处理工具类
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月29日
 * @version 1.0
 */
public class LoginUserCheckUtils {

	/**
     * 日志对象
     */
	private static Logger logger = LoggerFactory.getLogger(LoginUserCheckUtils.class);

	private static MembInfoMapper membInfoMapper = SpringBootContext.getBean(MembInfoMapper.class);

	private static OrderInfosMapper orderInfoMapper = SpringBootContext.getBean(OrderInfosMapper.class);
	/**
	 * 验证同城或者产地登录的验证处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月29日
	 * @version 1.0
	 */
	public static ResultPoJo<String>  checkLocOrCityLogin(String loginType,String loginName,String regTel){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		// 根据用户名称或者手机号查询用户信息
		LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
		loginNameOrMobilePo.setLoginName(loginName);
		loginNameOrMobilePo.setMobile(regTel);
		MembInfo checkMembInfo = membInfoMapper.loginCheck(loginNameOrMobilePo);
		if(checkMembInfo != null && ConverterUtil.isNotEmpty(checkMembInfo.getLoginName())
				&& ConverterUtil.isNotEmpty(checkMembInfo.getId())){
			if(ConverterUtil.isNotEmpty(loginName)){
				result.setResult(checkMembInfo.getLoginName());
			}else{
				result.setResult(ConverterUtil.toString(checkMembInfo.getId()));
			}
			// 当后台登录的情况
			if("admin".equals(loginType) && DictConstants.MEMB_TYPE_1.equals(checkMembInfo.getMembType())){
				// 账号冻结
				if(checkMembInfo.getAcctState() != null && DictConstants.ACCT_STATE_1.equals(checkMembInfo.getAcctState())){
					result.setCode(ConstantCodeMsg.ERR_908);
					result.setMsg(ConstantCodeMsg.MSG_908);
					return result;
				}

			// 当web登录的情况
			}else if("web".equals(loginType) && DictConstants.MEMB_TYPE_0.equals(checkMembInfo.getMembType())){
				// 账号冻结
				if(checkMembInfo.getAcctState() != null && DictConstants.ACCT_STATE_1.equals(checkMembInfo.getAcctState())){
					result.setCode(ConstantCodeMsg.ERR_908);
					result.setMsg(ConstantCodeMsg.MSG_908);
					return result;
				}
			}else if(ConverterUtil.isNotEmpty(loginType) && DictConstants.MEMB_TYPE_0.equals(checkMembInfo.getMembType())){
				// 账号冻结
				if(checkMembInfo.getAcctState() != null && DictConstants.ACCT_STATE_1.equals(checkMembInfo.getAcctState())){
					result.setCode(ConstantCodeMsg.ERR_908);
					result.setMsg(ConstantCodeMsg.MSG_908);
					return result;
				}
				CheckValidPo  checkValidPo = new CheckValidPo();
				checkValidPo.setUserId(checkMembInfo.getId());
				checkValidPo.setLoginType(loginType);
				CheckValidVo check = orderInfoMapper.checkValid(checkValidPo);
				if (ConverterUtil.isEmpty(check)){
					result.setCode("999");
					result.setMsg("无法登陆该应用！请确认是否购买该应用！");
					return result;
				}
				if (check.getValidEndDate().isAfter(OffsetDateTime.now())){
					result.setCode("999");
					result.setMsg("该应用已到期！如需登录请购买！");
					return result;
				}

			}else{
				result.setCode(ConstantCodeMsg.ERR_907);
				result.setMsg(ConstantCodeMsg.MSG_907);
				return result;
			}
		}else{
			result.setCode(ConstantCodeMsg.ERR_907);
			result.setMsg(ConstantCodeMsg.MSG_907);
			return result;
		}
		return result;
	}

	/**
	 * 随机用户名处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月13日
	 * @version 1.0
	 */
	public static String getRandomUserName(){
		while (true) {
			String userName = IdGen.randomBase62(8);
			MembCheckLoginNamePo membCheckLoginNamePo = new MembCheckLoginNamePo();
			membCheckLoginNamePo.setLoginName(userName);
			int userNameCount = membInfoMapper.checkLoginNameExist(membCheckLoginNamePo);
			if (userNameCount <= 0) {
				return userName;
			}
		}
	}
}
