package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * InvoInfoListVo
 * 2021/01/26 16:30:07
 */
public class InvoInfoListVo {
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
     * 发票类型
     */
    @ApiModelProperty(value = "发票类型")
    private String invoType;

    /**
     * 发票类别
     */
    @ApiModelProperty(value = "发票类别")
    private String invoCatgType;

    /**
     * 发票抬头
     */
    @ApiModelProperty(value = "发票抬头")
    private String invoTitle;

    /**
     * 纳税人识别号
     */
    @ApiModelProperty(value = "纳税人识别号")
    private String taxIdentNum;

    /**
     * 发票内容类型
     */
    @ApiModelProperty(value = "发票内容类型")
    private String invoContentType;

    /**
     * 注册地址
     */
    @ApiModelProperty(value = "注册地址")
    private String registAddress;

    /**
     * 注册电话
     */
    @ApiModelProperty(value = "注册电话")
    private String registTel;

    /**
     * 开户银行
     */
    @ApiModelProperty(value = "开户银行")
    private String bankName;

    /**
     * 银行账户
     */
    @ApiModelProperty(value = "银行账户")
    private String bankAccNum;

    /**
     * 是否默认
     */
    @ApiModelProperty(value = "是否默认")
    private String defaultFlag;

    /**
     * 发票备注
     */
    @ApiModelProperty(value = "发票备注")
    private String invoRemarks;

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
     * 获取发票类型
     */
    public String getInvoType() {
        return invoType;
    }

    /**
     * 设置发票类型
     */
    public void setInvoType(String invoType) {
        this.invoType = invoType == null ? null : invoType.trim();
    }

    /**
     * 获取发票类别
     */
    public String getInvoCatgType() {
        return invoCatgType;
    }

    /**
     * 设置发票类别
     */
    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType == null ? null : invoCatgType.trim();
    }

    /**
     * 获取发票抬头
     */
    public String getInvoTitle() {
        return invoTitle;
    }

    /**
     * 设置发票抬头
     */
    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle == null ? null : invoTitle.trim();
    }

    /**
     * 获取纳税人识别号
     */
    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    /**
     * 设置纳税人识别号
     */
    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum == null ? null : taxIdentNum.trim();
    }

    /**
     * 获取发票内容类型
     */
    public String getInvoContentType() {
        return invoContentType;
    }

    /**
     * 设置发票内容类型
     */
    public void setInvoContentType(String invoContentType) {
        this.invoContentType = invoContentType == null ? null : invoContentType.trim();
    }

    /**
     * 获取注册地址
     */
    public String getRegistAddress() {
        return registAddress;
    }

    /**
     * 设置注册地址
     */
    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress == null ? null : registAddress.trim();
    }

    /**
     * 获取注册电话
     */
    public String getRegistTel() {
        return registTel;
    }

    /**
     * 设置注册电话
     */
    public void setRegistTel(String registTel) {
        this.registTel = registTel == null ? null : registTel.trim();
    }

    /**
     * 获取开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取银行账户
     */
    public String getBankAccNum() {
        return bankAccNum;
    }

    /**
     * 设置银行账户
     */
    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum == null ? null : bankAccNum.trim();
    }

    /**
     * 获取是否默认
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否默认
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 获取发票备注
     */
    public String getInvoRemarks() {
        return invoRemarks;
    }

    /**
     * 设置发票备注
     */
    public void setInvoRemarks(String invoRemarks) {
        this.invoRemarks = invoRemarks == null ? null : invoRemarks.trim();
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