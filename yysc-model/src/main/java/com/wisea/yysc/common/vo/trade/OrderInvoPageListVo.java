package com.wisea.yysc.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票返回参数
 */
@ApiModel("发票返回参数")
public class OrderInvoPageListVo {
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
     * 发票抬头
     */
    @ApiModelProperty(value = "发票抬头")
    private String invoTitle;

    /**
     * 发票内容
     */
    @ApiModelProperty(value = "发票内容")
    private String invoContentType;

    /**
     * 纳税人识别码
     */
    @ApiModelProperty(value = "纳税人识别码")
    private String taxIdentNum;

    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号")
    private String applNum;

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
     * 买家id
     */
    @ApiModelProperty(value = "买家id")
    private Long buyerId;

    /**
     * 买家账户
     */
    @ApiModelProperty(value = "买家账号")
    private String buyerName;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    public OrderInvoPageListVo() {
    }

    public OrderInvoPageListVo(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getInvoContentType() {
        return invoContentType;
    }

    public void setInvoContentType(String invoContentType) {
        this.invoContentType = invoContentType;
    }

    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

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

}
