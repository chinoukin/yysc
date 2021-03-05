package com.wisea.yysc.common.po.memb;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 手机号验证码注册及登录的PO
 * 
 * @author wangh(wisea)
 *
 * @date 2020年5月11日
 * @version 1.0
 */
@ApiModel("手机号验证码注册及登录的PO")
public class MobileValiLoginOrRegPo {

	@ApiModelProperty(value = "手机号")
	@Check(test = "required",requiredMsg="手机号不能为空")
	private String mobile;
	@ApiModelProperty(value = "手机验证码")
	@Check(test = "required",requiredMsg="验证码不能为空")	
	private String valCode;
	@ApiModelProperty(value = "密码不能为空")
	@Check(test = "required",requiredMsg="密码不能为空")
	private String password;
	@ApiModelProperty(value = "企业信息")
	private String entpName;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getValCode() {
		return valCode;
	}
	public void setValCode(String valCode) {
		this.valCode = valCode;
	}
}
