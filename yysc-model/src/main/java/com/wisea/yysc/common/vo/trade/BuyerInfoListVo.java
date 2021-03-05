package com.wisea.yysc.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.yysc.common.vo.product.ApplicationVisitMageInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("订单列表返回结果")
public class BuyerInfoListVo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 买方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID")
    private Long buyerId;

    /**
     * 支付方式（在线支付、账期支付）
     */
    @ApiModelProperty(value = "支付方式（在线支付、账期支付）")
    private String payMethodType;

    /**
     * 订单来源类型
     */
    @ApiModelProperty(value = "订单来源类型")
    private String sourceType;

    /**
     * 订单备注
     */
    @ApiModelProperty(value = "订单备注")
    private String ordRemarks;

    /**
     * 订单取消原因id
     */
    @JsonSerialize(using = IdSerializer.class)
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
    @ApiModelProperty(value = "商品总件数")
    private Integer commTotalCount;

    @ApiModelProperty(value = "买方名称")
    private String buyerName;

    @ApiModelProperty(value = "应用名称")
    private String commPubName;

    /**
     * 商品总金额(商品发布价格)
     */
    @ApiModelProperty(value = "商品总金额(商品发布价格)")
    private Double commTotalPrice;

    /**
     * 应付款金额(商家修改费用信息)
     */
    @ApiModelProperty(value = "应付款金额(商家修改费用信息)")
    private Double amountPayable;

    /**
     * 订单状态类型
     */
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    /**
     * 提交订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交订单日期")
    private OffsetDateTime referOrdDate;

    @ApiModelProperty(value = "应用图片url")
    private String url;

    /**
     * 配置应用的id
     */
    @ApiModelProperty(value = "配置应用的id")
    private Long applicationVisitId;

    /**
     * 应用开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "应用开始日期")
    private OffsetDateTime validStartDate;

    /**
     * 应用结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "应用结束日期")
    private OffsetDateTime validEndDate;

    @ApiModelProperty("应用配置的信息")
    private ApplicationVisitMageInfoVo applicationVisitMageInfoVo;

    @ApiModelProperty("登入账号")
    private String registTel;

    /**
     * 付款截止日
     */
    private OffsetDateTime payDeadLineDate;

    @ApiModelProperty("品类名称")
    private String commCatgName;

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public ApplicationVisitMageInfoVo getApplicationVisitMageInfoVo() {
        return applicationVisitMageInfoVo;
    }

    public void setApplicationVisitMageInfoVo(ApplicationVisitMageInfoVo applicationVisitMageInfoVo) {
        this.applicationVisitMageInfoVo = applicationVisitMageInfoVo;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public OffsetDateTime getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(OffsetDateTime validStartDate) {
        this.validStartDate = validStartDate;
    }

    public OffsetDateTime getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(OffsetDateTime validEndDate) {
        this.validEndDate = validEndDate;
    }

    public OffsetDateTime getPayDeadLineDate() {
        return payDeadLineDate;
    }

    public void setPayDeadLineDate(OffsetDateTime payDeadLineDate) {
        this.payDeadLineDate = payDeadLineDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getApplicationVisitId() {
        return applicationVisitId;
    }

    public void setApplicationVisitId(Long applicationVisitId) {
        this.applicationVisitId = applicationVisitId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrdRemarks() {
        return ordRemarks;
    }

    public void setOrdRemarks(String ordRemarks) {
        this.ordRemarks = ordRemarks;
    }

    public Long getOrdCancelReasonId() {
        return ordCancelReasonId;
    }

    public void setOrdCancelReasonId(Long ordCancelReasonId) {
        this.ordCancelReasonId = ordCancelReasonId;
    }

    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getCommPubName() {
        return commPubName;
    }

    public void setCommPubName(String commPubName) {
        this.commPubName = commPubName;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }
}
