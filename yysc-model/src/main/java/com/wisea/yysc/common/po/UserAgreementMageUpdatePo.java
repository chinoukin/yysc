package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserAgreementMageUpdatePo
 * 2021/02/04 10:50:41
 */
public class UserAgreementMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 用户协议
     */
    @Check(test = "required")
    @ApiModelProperty(value = "用户协议")
    private String userAgreement;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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