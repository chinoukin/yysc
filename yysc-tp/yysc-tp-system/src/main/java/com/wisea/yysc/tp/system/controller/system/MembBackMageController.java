package com.wisea.yysc.tp.system.controller.system;

import com.wisea.cloud.common.annotation.DataCheck;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.MembInfoGetPo;
import com.wisea.yysc.common.vo.memb.*;
import com.wisea.yysc.common.po.memb.*;
import com.wisea.yysc.tp.system.service.system.MembBackMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *  成员设置相关的接口
 *    wzx
 */
@Api(tags = "成员设置相关的接口")
@RestController
@RequestMapping(value="/w/account")
public class MembBackMageController {
	@Autowired
	private MembBackMageService membBackMageService;

	/**
	 * 根据id获取会员的基本信息
	 */
	@ApiOperation("【账户设置】根据id获取会员的基本信息")
	@PostMapping(value = "/getMembBaseInfo")
	@DataCheck
	public ResultPoJo<MembBaseDetailVo> getMembBaseInfo(@RequestBody MembInfoGetPo membInfoGetPo){
		// 返回参数
		return membBackMageService.getMembBaseInfo(membInfoGetPo);
	}
	/**
	 * 修改登录密码(修改当前用户的密码)
	 */
	@ApiOperation("【账户设置】修改登录密码(修改当前用户的密码)")
	@PostMapping(value = "/updPwd")
	@DataCheck
	public ResultPoJo<String> userUpdPwd(@RequestBody MembPwdUpdatePo membPwdUpdatePo){
		// 返回参数
		return membBackMageService.userUpdPwd(membPwdUpdatePo);
	}
	/**
	 * 保存会员头像信息(修改当前用户头像)
	 */
	@ApiOperation("【账户设置】保存会员头像信息(修改当前用户头像)")
	@PostMapping(value = "/saveMembUrl")
	@DataCheck
	public ResultPoJo<String> saveMembUrl(@RequestBody StringPo stringPo){
		// 返回参数
		return membBackMageService.saveMembUrl(stringPo);
	}


}
