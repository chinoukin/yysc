package com.wisea.yysc.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取会员的基础信息VO
 *
 */
@ApiModel("获取会员的基础信息VO")
public class MembBaseDetailVo {
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="ID")
    private Long id;
	@ApiModelProperty(value = "用户头像")
	private String logoUrl;
	@ApiModelProperty(value="用户名")
	private String contName;
	@ApiModelProperty(value = "邮箱")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}