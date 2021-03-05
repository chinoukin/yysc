package com.wisea.yysc.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserAgreementMageInsertPo
 * 2021/02/04 10:50:41
 */
public class UserAgreementMageInsertPo {
    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 用户协议
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "用户协议")
    private String userAgreement;

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取用户协议
     */
    public String getUserAgreement() {
        return userAgreement;
    }

    /**
     * 设置用户协议
     */
    public void setUserAgreement(String userAgreement) {
        this.userAgreement = userAgreement == null ? null : userAgreement.trim();
    }
}