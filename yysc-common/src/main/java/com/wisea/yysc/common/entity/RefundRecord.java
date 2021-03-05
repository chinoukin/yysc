package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * refund_record 表实体
 * 退款记录
 * 2021/01/26 16:30:07
 */
public class RefundRecord extends DataLongEntity<RefundRecord> {
    private static final long serialVersionUID = 1L;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 订单id
     */
    private String ordId;

    /**
     * 商户唯一订单号
     */
    private String outTradeNo;

    /**
     * 退款金额
     */
    private String refundAmount;

    /**
     * 退款状态
     */
    private String refundState;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 唯一请求号
     */
    private String outRequestNo;

    /**
     * 交易类型
     */
    private String tranType;

    /**
     * 获取支付渠道
     */
    public String getPayChannel() {
        return payChannel;
    }

    /**
     * 设置支付渠道
     */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    /**
     * 获取订单id
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }

    /**
     * 获取商户唯一订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置商户唯一订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * 获取退款金额
     */
    public String getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额
     */
    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount == null ? null : refundAmount.trim();
    }

    /**
     * 获取退款状态
     */
    public String getRefundState() {
        return refundState;
    }

    /**
     * 设置退款状态
     */
    public void setRefundState(String refundState) {
        this.refundState = refundState == null ? null : refundState.trim();
    }

    /**
     * 获取交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取唯一请求号
     */
    public String getOutRequestNo() {
        return outRequestNo;
    }

    /**
     * 设置唯一请求号
     */
    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo == null ? null : outRequestNo.trim();
    }

    /**
     * 获取交易类型
     */
    public String getTranType() {
        return tranType;
    }

    /**
     * 设置交易类型
     */
    public void setTranType(String tranType) {
        this.tranType = tranType == null ? null : tranType.trim();
    }
}