package com.wisea.yysc.operation.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.CacheKey;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.PwdBackConfirmPo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.properties.LoginOauthProperties;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.BusEventsService;
import com.wisea.cloud.common.service.ValidateCodeService;
import com.wisea.cloud.common.sms.SmsService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.WbfcJwtOauthUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.rabbit.events.info.UserLoginEventInfo;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.entity.MembInfo;
import com.wisea.yysc.common.po.memb.*;
import com.wisea.yysc.common.vo.memb.MembForgotPwdVo;
import com.wisea.yysc.operation.utils.JwtCreateUtils;
import com.wisea.yysc.operation.utils.LoginUserCheckUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 登录相关的Service
 * 
 * @author wangh(wisea)
 *
 * @date 2020年5月11日
 * @version 1.0
 */
@Service
@EnableConfigurationProperties(LoginOauthProperties.class)
public class UserLoginExtendsService extends BaseService{

	@Autowired
	private JedisDao jedisDao;
	@Autowired
	private LoginOauthProperties loginOauthProperties;
	@Autowired
	private BusEventsService busEventsService;
	@Autowired
	private ValidateCodeService validateCodeService;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private RemoteUserMss remoteUserMss;
	@Autowired
	private SmsService smsService;

	/**
	 *  手机号登录处理
	 * 
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	public  ResultPoJo<AuthInfo> mobileLogin(HttpServletRequest request, MobileValiLoginPo po, Long userId, boolean isVliMobile){
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		AuthInfo info = null;
		User user = UserUtils.getById(userId);
		// 用户是否存在的验证
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantError.ERR_907);
			result.setMsg(ConstantError.MSG_907);
			return result;
		}
		// 校验不通过
        if (isVliMobile && !validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), false)) {
            // 验证码错误或已过期
            result.setCode(ConstantError.ERR_904);
			result.setMsg(ConstantError.MSG_904);
			return result;
        }
		// 校验登录flag
        if (!Constants.YES.equals(user.getLoginFlag())) {
            // 不允许登录
            result.setCode(ConstantError.ERR_908);
			result.setMsg(ConstantError.MSG_908);
			return result;
        }
        // 校验有效期是否過期
        if (ConverterUtil.isNotEmpty(user.getAvailableDate()) && user.getAvailableDate().compareTo(OffsetDateTime.now()) <= 0) {
            // 用户已过期
            result.setCode(ConstantError.ERR_909);
			result.setMsg(ConstantError.MSG_909);
			return result;
        }
        // 从redis获取token
        String jwtKey = CacheKey.getJwtTokenKey(user.getLoginName());
        String tokenStr = jedisDao.getStr(jwtKey);
        if (ConverterUtil.isEmpty(tokenStr)) {
        	// 获取 author
        	String[] author = JwtCreateUtils.getAuthor(user);
        	Map<String, Object> headerMap = Maps.newLinkedHashMap();
            headerMap.put("typ", "JWT");
        	tokenStr = Jwts.builder().setSubject(user.getLoginName()).claim("user_name",user.getLoginName()).claim("openId", user.getOpenId())
                    .claim("userId", user.getId()).claim("authorities", author).setExpiration(new Date(System.currentTimeMillis() + loginOauthProperties.getExpire() * 1000)).setHeader(headerMap)
                    .signWith(SignatureAlgorithm.RS256, WbfcJwtOauthUtil.getPrivateKey()).compact();
            // 设置自动过期的token到redis
            jedisDao.setStrExpire(jwtKey, tokenStr, loginOauthProperties.getExpire());
        }
        
        info = new AuthInfo("bearer", tokenStr, "", user);
        // 发送登录消息，若没有配置busevents则不会发送
        UserLoginEventInfo eventInfo = new UserLoginEventInfo();
        String ip = SystemUtils.getIpAddr(request);
        eventInfo.setUser(user);
        eventInfo.setIp(ip);
        eventInfo.setLoginDate(OffsetDateTime.now());
        eventInfo.setParam(ConverterUtil.toString(po));
        busEventsService.sendUserLoginEvent(eventInfo);
        result.setResult(info);
        // 手机验证码清空
        if(isVliMobile){
        	validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), true);        	
        }
        return result;
	}
	/**
	 * 手机号验证码登录的处理
	 * 
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月11日
	 * @version 1.0
	 */
	public ResultPoJo<AuthInfo> mobileValiCodeLogin(HttpServletRequest request,MobileValiLoginPo po){ 
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		// 获取登录类型
        String loginType = ConverterUtil.toString(request.getParameter("ltype"), "city_bus");
		// 用户名密码的验证
		if(ConverterUtil.isNotEmpty(po.getMobile(), po.getValCode())){
			// 验证处理
			ResultPoJo<String> checkResult = LoginUserCheckUtils.checkLocOrCityLogin(loginType, null,po.getMobile());
			if(checkResult != null && ConstantCodeMsg.NOMAL.equals(checkResult.getCode())
					&& ConverterUtil.isNotEmpty(checkResult.getResult())){
				// 登录处理
	            result = this.mobileLogin(request, po, ConverterUtil.toLong(checkResult.getResult()),true);
			}else{
				result.setCode(ConstantError.ERR_907);
				result.setMsg(ConstantError.MSG_907);
				return result;
			}
        }else{
            // 手机号和验证码不能为空
            result.setCode(ConstantCodeMsg.ERR_005);
			result.setMsg("手机号或者验证码不能为空");
			return result;
        }
		return result;
	}
	/**
	 * 手机号验证码登录处理(如果手机号不存在则注册新的账户后登录处理)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<AuthInfo> mobileLoginOrReg(HttpServletRequest request, MobileValiLoginOrRegPo po){
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		// 手机号和验证码不能为空
		if(ConverterUtil.isNotEmpty(po.getMobile(), po.getValCode())){
			Long userId = null;
			// 通过注册手机号查询用户信息
    		MembInfo existInfo = membInfoMapper.getMembInfoByRegTel(po.getMobile());
			// 如果为空的情况需要注册处理
			if(existInfo == null || ConverterUtil.isEmpty(existInfo.getId())){
				// 校验不通过
		        if (!validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), false)) {
		            // 验证码错误或已过期
		            result.setCode(ConstantError.ERR_904);
					result.setMsg(ConstantError.MSG_904);
					return result;
		        }
				// 数据库中该手机号没有注册的情况 注册新用户
				String pwd = IdGen.randomBase62(32);
				String userName = LoginUserCheckUtils.getRandomUserName();
				// 本地数据库会员表的插入
				MembInfo membInfo = new MembInfo();
				membInfo.preInsert();
				userId = membInfo.getId();
				membInfo.setLoginName(userName);
				membInfo.setRegistTel(po.getMobile());
				// 新增的时候设置默认值
				membInfo.setRegistDate(OffsetDateTime.now());
				membInfo.setMembType(DictConstants.MEMB_TYPE_0); //用户类型
				membInfo.setAcctState(DictConstants.ACCT_STATE_0);//账户状态0：正常
				membInfo.setPetName("XMFK"+po.getMobile());//昵称
				membInfo.setRegistDate(OffsetDateTime.now()); //注册时间
				membInfoMapper.insertSelective(membInfo);
				// 验证用户名是否已经存在 注册用户
				RegisterUserMembPo registerUserMembPo = new RegisterUserMembPo();
				registerUserMembPo.setId(userId);
				registerUserMembPo.setLoginName(userName);// 用户名
				registerUserMembPo.setPassword(po.getPassword());//  随机密码
				registerUserMembPo.setMobile(po.getMobile());// 手机号
				List<String> roleList = new ArrayList<String>();
				roleList.add("ROLE_person");
				registerUserMembPo.setRoleCodes(roleList);// 个人的情况
				registerUserMembPo.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
				ResultPoJo<User> userResult = remoteUserMss.register(registerUserMembPo);
				if(!userResult.getCode().equals(ConstantError.NOMAL)
						|| ConverterUtil.isEmpty(userResult.getResult().getId())){
					checkRemoteResult(userResult);
				}
			}else{
				userId = existInfo.getId();
				// 判断是否允许登录
				LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
				loginNameOrMobilePo.setMobile(po.getMobile());
				MembInfo membInfo = membInfoMapper.loginCheck(loginNameOrMobilePo);
				if(membInfo != null && "1".equals(membInfo.getMembType())){
					result.setCode(ConstantCodeMsg.ERR_955);
					result.setMsg(ConstantCodeMsg.MSG_955);
					return result;
				}
			}
			MobileValiLoginPo mobileValiLoginPo = new MobileValiLoginPo();
			mobileValiLoginPo.setMobile(po.getMobile());
			mobileValiLoginPo.setValCode(po.getValCode());
			// 登录处理
            result = this.mobileLogin(request, mobileValiLoginPo, userId,true);
		}else{
			// 手机号和验证码不能为空
            result.setCode(ConstantCodeMsg.ERR_005);
			result.setMsg("手机号或者验证码不能为空");
			return result;
		}
		return result;
	}
	/**
	 * 忘记密码(点击发送手机验证码操作)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月29日
	 * @version 1.0
	 */
	public ResultPoJo<MembForgotPwdVo> forgotPwdGetMobile(StringPo po){
		//  返回参数
		ResultPoJo<MembForgotPwdVo> result = new ResultPoJo<MembForgotPwdVo>(ConstantError.NOMAL);
		MembForgotPwdVo membForgotVo = new MembForgotPwdVo();
		//验证手机号是否存在
		MembInfo membBaseInfo = membInfoMapper.getMembInfoByRegTel(po.getKeyStr());
		if(ConverterUtil.isEmpty(membBaseInfo)){
			result.setCode(ConstantCodeMsg.ERR_528);
			result.setMsg(ConstantCodeMsg.MSG_528);
			return result;
		}
		// 设置key
		ResultPoJo<Object> userResult = remoteUserMss.pwdBackApply(membBaseInfo.getLoginName());
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(userResult);
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			return result;
		}else{
			// 从redis查询是否有过记录，如果有就不再设置 默认超时:600秒
			String applyKey = CacheKey.getPwdBack(membBaseInfo.getLoginName());
			String redisValu = jedisDao.getStr(applyKey);
			if (ConverterUtil.isNotEmpty(redisValu)) {
				membForgotVo.setKeyCode(redisValu);
				membForgotVo.setMobile(membBaseInfo.getRegistTel());
				result.setResult(membForgotVo);
				return result;
			}else{
				result.setCode(ConstantCodeMsg.ERR_506);
				result.setMsg(ConstantCodeMsg.MSG_506);
			}
		}
		return result;
	}

	/**
	 * 忘记密码保存操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月28日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> forgotPassword(MembForgotPwdPo po){
		//  返回参数
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		//验证手机号是否存在
		MembInfo membBaseInfo = membInfoMapper.getMembInfoByRegTel(po.getMobile());
		//MembBaseInfo membBaseInfo = membInfoMapper.getMembInfoByMobile(po.getMobile());
		if(ConverterUtil.isEmpty(membBaseInfo)){
			result.setCode(ConstantCodeMsg.ERR_528);
			result.setMsg(ConstantCodeMsg.MSG_528);
			return result;
		}
		// 验证短信验证码是否正确
		if(!validateCodeService.checkSMSCode(membBaseInfo.getRegistTel(),po.getMobileCode(),true)){
			result.setCode(ConstantCodeMsg.ERR_503);
			result.setMsg(ConstantCodeMsg.MSG_503);
			return result;
		}
		// 调用接口修改密码
		if(ConverterUtil.isNotEmpty(po.getKeyCode())){
			PwdBackConfirmPo pwdBackConfirmPo = new PwdBackConfirmPo();
			pwdBackConfirmPo.setCheckKey(po.getKeyCode());
			pwdBackConfirmPo.setNewPassword(po.getNewPwd());
			pwdBackConfirmPo.setLoginName(membBaseInfo.getLoginName());
			ResultPoJo<Object> userResult = remoteUserMss.pwdBackConfirm(pwdBackConfirmPo);
			if(!userResult.getCode().equals(ConstantError.NOMAL)){
				result.setCode(userResult.getCode());
				result.setMsg(userResult.getMsg());
				checkRemoteResult(userResult);
				return result;
			}
		}else{
			result.setCode(ConstantCodeMsg.ERR_507);
			result.setMsg(ConstantCodeMsg.MSG_507);
		}
		return result;
	}


}
