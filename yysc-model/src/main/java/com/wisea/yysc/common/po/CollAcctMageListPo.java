package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CollAcctMageListPo
 * 2021/02/04 10:50:41
 */
public class CollAcctMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 开户名
     */
    @ApiModelProperty(value = "开户名")
    private String acctName;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String acctNum;

    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    private String bankDeposit;

    /**
     * 开户地省
     */
    @ApiModelProperty(value = "开户地省")
    private String bankProv;

    /**
     * 开户地市
     */
    @ApiModelProperty(value = "开户地市")
    private String bankCity;

    /**
     * 开户支行
     */
    @ApiModelProperty(value = "开户支行")
    private String bankSub;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

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
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取开户名
     */
    public String getAcctName() {
        return acctName;
    }

    /**
     * 设置开户名
     */
    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    /**
     * 获取账号
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     * 设置账号
     */
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum == null ? null : acctNum.trim();
    }

    /**
     * 获取开户行
     */
    public String getBankDeposit() {
        return bankDeposit;
    }

    /**
     * 设置开户行
     */
    public void setBankDeposit(String bankDeposit) {
        this.bankDeposit = bankDeposit == null ? null : bankDeposit.trim();
    }

    /**
     * 获取开户地省
     */
    public String getBankProv() {
        return bankProv;
    }

    /**
     * 设置开户地省
     */
    public void setBankProv(String bankProv) {
        this.bankProv = bankProv == null ? null : bankProv.trim();
    }

    /**
     * 获取开户地市
     */
    public String getBankCity() {
        return bankCity;
    }

    /**
     * 设置开户地市
     */
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity == null ? null : bankCity.trim();
    }

    /**
     * 获取开户支行
     */
    public String getBankSub() {
        return bankSub;
    }

    /**
     * 设置开户支行
     */
    public void setBankSub(String bankSub) {
        this.bankSub = bankSub == null ? null : bankSub.trim();
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
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}