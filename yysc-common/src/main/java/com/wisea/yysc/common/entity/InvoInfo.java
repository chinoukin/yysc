package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * invo_info 表实体
 * 发票信息
 * 2021/01/26 16:30:07
 */
public class InvoInfo extends DataLongEntity<InvoInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 发票类型
     */
    private String invoType;

    /**
     * 发票类别
     */
    private String invoCatgType;

    /**
     * 发票抬头
     */
    private String invoTitle;

    /**
     * 纳税人识别号
     */
    private String taxIdentNum;

    /**
     * 发票内容类型
     */
    private String invoContentType;

    /**
     * 注册地址
     */
    private String registAddress;

    /**
     * 注册电话
     */
    private String registTel;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行账户
     */
    private String bankAccNum;

    /**
     * 是否默认
     */
    private String defaultFlag;

    /**
     * 发票备注
     */
    private String invoRemarks;

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
}