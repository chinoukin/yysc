package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * OrderInfoInsertPo
 * 2021/01/26 16:30:07
 */
public class OrderInfoInsertPo {
    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 订单编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 买方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "买方ID")
    private Long buyerId;

    /**
     * 支付方式（在线支付、账期支付）
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "支付方式（在线支付、账期支付）")
    private String payMethodType;

    /**
     * 订单来源类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "订单来源类型")
    private String sourceType;

    /**
     * 订单备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单备注")
    private String ordRemarks;

    /**
     * 订单取消原因id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "订单取消原因id")
    private Long ordCancelReasonId;

    /**
     * 订单取消时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "订单取消时间")
    private OffsetDateTime ordCancelDate;

    /**
     * 支付订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "支付订单日期")
    private OffsetDateTime payOrdDate;

    /**
     * 商品总件数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "商品总件数")
    private Integer commTotalCount;

    /**
     * 卖方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "卖方ID")
    private Long sellerId;

    /**
     * 商品总金额(商品发布价格)
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "商品总金额(商品发布价格)")
    private Double commTotalPrice;

    /**
     * 订单状态类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    /**
     * 提交订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交订单日期")
    private OffsetDateTime referOrdDate;

    /**
     * 卖方确定日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "卖方确定日期")
    private OffsetDateTime sellerSureDate;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    /**
     * 获取买方ID
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买方ID
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 获取支付方式（在线支付、账期支付）
     */
    public String getPayMethodType() {
        return payMethodType;
    }

    /**
     * 设置支付方式（在线支付、账期支付）
     */
    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType == null ? null : payMethodType.trim();
    }

    /**
     * 获取订单来源类型
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置订单来源类型
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取订单备注
     */
    public String getOrdRemarks() {
        return ordRemarks;
    }

    /**
     * 设置订单备注
     */
    public void setOrdRemarks(String ordRemarks) {
        this.ordRemarks = ordRemarks == null ? null : ordRemarks.trim();
    }

    /**
     * 获取订单取消原因id
     */
    public Long getOrdCancelReasonId() {
        return ordCancelReasonId;
    }

    /**
     * 设置订单取消原因id
     */
    public void setOrdCancelReasonId(Long ordCancelReasonId) {
        this.ordCancelReasonId = ordCancelReasonId;
    }

    /**
     * 获取订单取消时间
     */
    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    /**
     * 设置订单取消时间
     */
    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    /**
     * 获取支付订单日期
     */
    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    /**
     * 设置支付订单日期
     */
    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    /**
     * 获取商品总件数
     */
    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    /**
     * 设置商品总件数
     */
    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    /**
     * 获取卖方ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖方ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取商品总金额(商品发布价格)
     */
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    /**
     * 设置商品总金额(商品发布价格)
     */
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    /**
     * 获取订单状态类型
     */
    public String getOrderStateType() {
        return orderStateType;
    }

    /**
     * 设置订单状态类型
     */
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType == null ? null : orderStateType.trim();
    }

    /**
     * 获取提交订单日期
     */
    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    /**
     * 设置提交订单日期
     */
    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    /**
     * 获取卖方确定日期
     */
    public OffsetDateTime getSellerSureDate() {
        return sellerSureDate;
    }

    /**
     * 设置卖方确定日期
     */
    public void setSellerSureDate(OffsetDateTime sellerSureDate) {
        this.sellerSureDate = sellerSureDate;
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
}