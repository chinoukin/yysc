package com.wisea.yysc.operation.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.po.memb.MembForgotPwdPo;
import com.wisea.yysc.common.po.memb.MobileValiLoginOrRegPo;
import com.wisea.yysc.common.po.memb.MobileValiLoginPo;
import com.wisea.yysc.common.po.memb.StringPo;
import com.wisea.yysc.common.vo.memb.MembForgotPwdVo;
import com.wisea.yysc.operation.service.UserLoginExtendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 微信小程序模拟登录的Controller
 * 
 * @author wangh(wisea)
 *
 * @date 2018年11月12日
 * @version 1.0
 */
@RestController
@Api(tags = "手机登录扩展信息操作接口")
public class WeChatMiProController {

	@Autowired
	private UserLoginExtendsService userLoginExtendsService;
	
	/**
	 * 注册手机号验证码登录的
	 * 
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月12日
	 * @version 1.0
	 */
	@ApiOperation("注册手机号验证码登录的(/mobileLogin?ltype=(admin:后台 web:前台   默认是是admin))")
	@PostMapping(value = { "/mobileLogin" })
	public ResultPoJo<AuthInfo> mobileLogin(HttpServletRequest request,
			@RequestBody MobileValiLoginPo po){
		// 登录并且返回
		return userLoginExtendsService.mobileValiCodeLogin(request, po);
	}
	
	/**
	 * 注册手机号验证码登录(如果手机号不存在则注册新的账号)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月12日
	 * @version 1.0
	 */
	@ApiOperation(nickname = "注册手机号验证码登录(如果手机号不存在则注册新的账号)",value = "注册手机号验证码登录(如果手机号不存在则注册新的账号)")
	@PostMapping(value = { "/mobileLoginReg" })
	public ResultPoJo<AuthInfo> mobileLoginOrReg(HttpServletRequest request,
			@RequestBody MobileValiLoginOrRegPo po){
		// 登录并且返回
		return userLoginExtendsService.mobileLoginOrReg(request, po);
	}

	/**
	 * 忘记密码-点击发送手机验证码的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月29日
	 * @version 1.0
	 */
	@ApiOperation(value = "忘记密码-点击发送手机验证码的操作",notes = "忘记密码-点击发送手机验证码的操作")
	@PostMapping(value = "/memb/getMobile")
	@DataCheck
	public ResultPoJo<MembForgotPwdVo> forgotPwdGetMobile(@RequestBody StringPo stringPo){
		// 返回参数
		return userLoginExtendsService.forgotPwdGetMobile(stringPo);
	}
	/**
	 * 忘记密码保存操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年9月25日
	 * @version 1.0
	 */
	@ApiOperation( value = "忘记密码保存操作",notes = "忘记密码保存操作")
	@PostMapping(value = "/memb/forgotPassword")
	@DataCheck
	public ResultPoJo<String> forgotPassword(@RequestBody MembForgotPwdPo membForgotPwdPo){
		// 返回参数
		return userLoginExtendsService.forgotPassword(membForgotPwdPo);
	}
}
