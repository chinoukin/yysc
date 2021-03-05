package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * order_info 表实体
 * 订单信息
 * 2021/01/26 16:30:07
 */
public class OrderInfo extends DataLongEntity<OrderInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 买方ID
     */
    private Long buyerId;

    /**
     * 支付方式（在线支付、账期支付）
     */
    private String payMethodType;

    /**
     * 订单来源类型
     */
    private String sourceType;

    /**
     * 订单备注
     */
    private String ordRemarks;

    /**
     * 订单取消原因id
     */
    private Long ordCancelReasonId;

    /**
     * 订单取消时间
     */
    private OffsetDateTime ordCancelDate;

    /**
     * 支付订单日期
     */
    private OffsetDateTime payOrdDate;

    /**
     * 商品总件数
     */
    private Integer commTotalCount;

    /**
     * 卖方ID
     */
    private Long sellerId;

    /**
     * 商品总金额(商品发布价格)
     */
    private Double commTotalPrice;

    /**
     * 应付款金额(商品总金额,后台修改费用信息)
     */
    private Double amountPayable;

    /**
     * 订单状态类型
     */
    private String orderStateType;

    /**
     * 提交订单日期
     */
    private OffsetDateTime referOrdDate;

    /**
     * 卖方确定日期
     */
    private OffsetDateTime sellerSureDate;

    /**
     * 应用开始时间
     */
    private OffsetDateTime validStartDate;

    /**
     * 应用结束时间
     */
    private OffsetDateTime validEndDate;

    /**
     * 付款截止日
     */
    private OffsetDateTime payDeadLineDate;

    /**
     * 买家确认审核时间
     */
    private OffsetDateTime sellerExamDate;

    /**
     * 商品规格id
     */
    private Long levelSpecId;

    /**
     * 试用/正式订单类型
     */
    private String tryOrdType;

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public String getTryOrdType() {
        return tryOrdType;
    }

    public void setTryOrdType(String tryOrdType) {
        this.tryOrdType = tryOrdType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public OffsetDateTime getSellerExamDate() {
        return sellerExamDate;
    }

    public void setSellerExamDate(OffsetDateTime sellerExamDate) {
        this.sellerExamDate = sellerExamDate;
    }

    public Long getLevelSpecId() {
        return levelSpecId;
    }

    public void setLevelSpecId(Long levelSpecId) {
        this.levelSpecId = levelSpecId;
    }

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
}