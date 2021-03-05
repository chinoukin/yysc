package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OrdInvoListVo
 * 2021/01/26 16:30:07
 */
public class OrdInvoListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    /**
     * 发票类型
     */
    @ApiModelProperty(value = "发票类型")
    private String invoType;

    /**
     * 发票形式
     */
    @ApiModelProperty(value = "发票形式")
    private String invoForm;

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
     * 收件人
     */
    @ApiModelProperty(value = "收件人")
    private String receName;

    /**
     * 收件人手机号
     */
    @ApiModelProperty(value = "收件人手机号")
    private String consigneeTel;

    /**
     * 所在地区省
     */
    @ApiModelProperty(value = "所在地区省")
    private String addressProv;

    /**
     * 所在地区市
     */
    @ApiModelProperty(value = "所在地区市")
    private String addressCity;

    /**
     * 所在地区区县
     */
    @ApiModelProperty(value = "所在地区区县")
    private String addressCou;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String zipCode;

    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号")
    private String applNum;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;

    /**
     * 开票日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开票日期")
    private OffsetDateTime drawDate;

    /**
     * 开票金额
     */
    @ApiModelProperty(value = "开票金额")
    private Double drawAmount;

    /**
     * 发票状态
     */
    @ApiModelProperty(value = "发票状态")
    private String invoState;

    /**
     * 发票内容类型
     */
    @ApiModelProperty(value = "发票内容类型")
    private String invoContentType;

    /**
     * 物流公司名称
     */
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    /**
     * 物流单号
     */
    @ApiModelProperty(value = "物流单号")
    private String logisticsNum;

    /**
     * 录入开票结果类型
     */
    @ApiModelProperty(value = "录入开票结果类型")
    private String entryOpenInvoType;

    /**
     * 申请备注
     */
    @ApiModelProperty(value = "申请备注")
    private String applRemarks;

    /**
     * 开票备注
     */
    @ApiModelProperty(value = "开票备注")
    private String openInvoRemarks;

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
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
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
     * 获取发票形式
     */
    public String getInvoForm() {
        return invoForm;
    }

    /**
     * 设置发票形式
     */
    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm == null ? null : invoForm.trim();
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
     * 获取收件人
     */
    public String getReceName() {
        return receName;
    }

    /**
     * 设置收件人
     */
    public void setReceName(String receName) {
        this.receName = receName == null ? null : receName.trim();
    }

    /**
     * 获取收件人手机号
     */
    public String getConsigneeTel() {
        return consigneeTel;
    }

    /**
     * 设置收件人手机号
     */
    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel == null ? null : consigneeTel.trim();
    }

    /**
     * 获取所在地区省
     */
    public String getAddressProv() {
        return addressProv;
    }

    /**
     * 设置所在地区省
     */
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv == null ? null : addressProv.trim();
    }

    /**
     * 获取所在地区市
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * 设置所在地区市
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    /**
     * 获取所在地区区县
     */
    public String getAddressCou() {
        return addressCou;
    }

    /**
     * 设置所在地区区县
     */
    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou == null ? null : addressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    /**
     * 获取邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 获取申请单号
     */
    public String getApplNum() {
        return applNum;
    }

    /**
     * 设置申请单号
     */
    public void setApplNum(String applNum) {
        this.applNum = applNum == null ? null : applNum.trim();
    }

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取开票日期
     */
    public OffsetDateTime getDrawDate() {
        return drawDate;
    }

    /**
     * 设置开票日期
     */
    public void setDrawDate(OffsetDateTime drawDate) {
        this.drawDate = drawDate;
    }

    /**
     * 获取开票金额
     */
    public Double getDrawAmount() {
        return drawAmount;
    }

    /**
     * 设置开票金额
     */
    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    /**
     * 获取发票状态
     */
    public String getInvoState() {
        return invoState;
    }

    /**
     * 设置发票状态
     */
    public void setInvoState(String invoState) {
        this.invoState = invoState == null ? null : invoState.trim();
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
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取物流单号
     */
    public String getLogisticsNum() {
        return logisticsNum;
    }

    /**
     * 设置物流单号
     */
    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    /**
     * 获取录入开票结果类型
     */
    public String getEntryOpenInvoType() {
        return entryOpenInvoType;
    }

    /**
     * 设置录入开票结果类型
     */
    public void setEntryOpenInvoType(String entryOpenInvoType) {
        this.entryOpenInvoType = entryOpenInvoType == null ? null : entryOpenInvoType.trim();
    }

    /**
     * 获取申请备注
     */
    public String getApplRemarks() {
        return applRemarks;
    }

    /**
     * 设置申请备注
     */
    public void setApplRemarks(String applRemarks) {
        this.applRemarks = applRemarks == null ? null : applRemarks.trim();
    }

    /**
     * 获取开票备注
     */
    public String getOpenInvoRemarks() {
        return openInvoRemarks;
    }

    /**
     * 设置开票备注
     */
    public void setOpenInvoRemarks(String openInvoRemarks) {
        this.openInvoRemarks = openInvoRemarks == null ? null : openInvoRemarks.trim();
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