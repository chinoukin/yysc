package com.wisea.yysc.common.po.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("注册用户传入参数")
public class MembInfoRegisterPo {

    @ApiModelProperty("手机号")
    private String tel;
    @ApiModelProperty("验证码")
    private String velCode;
    @ApiModelProperty("手机号")
    private String mebelCode;
    @ApiModelProperty("password")
    private String password;
    @ApiModelProperty("企业名称")
    private String entpName;

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVelCode() {
        return velCode;
    }

    public void setVelCode(String velCode) {
        this.velCode = velCode;
    }

    public String getMebelCode() {
        return mebelCode;
    }

    public void setMebelCode(String mebelCode) {
        this.mebelCode = mebelCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
