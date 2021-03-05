package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * pay_record 表实体
 * 支付记录
 * 2021/01/26 16:30:07
 */
public class PayRecord extends DataLongEntity<PayRecord> {
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
     * 支付金额
     */
    private String payAmount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 支付状态
     */
    private String payState;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 交易类型
     */
    private String tranType;

    /**
     * 支付截止时间
     */
    private OffsetDateTime payEndtime;

    /**
     * 支付链接
     */
    private String payUrl;

    /**
     * 平台分类
     */
    private String platformType;

    /**
     * 阶段编号
     */
    private Integer stageNo;

    /**
     * 用于乐观锁的时间戳
     */
    private OffsetDateTime lockDate;

    public OffsetDateTime getLockDate() {
        return lockDate;
    }

    public void setLockDate(OffsetDateTime lockDate) {
        this.lockDate = lockDate;
    }

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
     * 获取支付金额
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount == null ? null : payAmount.trim();
    }

    /**
     * 获取订单标题
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置订单标题
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 获取支付状态
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 设置支付状态
     */
    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
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

    /**
     * 获取支付截止时间
     */
    public OffsetDateTime getPayEndtime() {
        return payEndtime;
    }

    /**
     * 设置支付截止时间
     */
    public void setPayEndtime(OffsetDateTime payEndtime) {
        this.payEndtime = payEndtime;
    }

    /**
     * 获取支付链接
     */
    public String getPayUrl() {
        return payUrl;
    }

    /**
     * 设置支付链接
     */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl == null ? null : payUrl.trim();
    }

    /**
     * 获取平台分类
     */
    public String getPlatformType() {
        return platformType;
    }

    /**
     * 设置平台分类
     */
    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    /**
     * 获取阶段编号
     */
    public Integer getStageNo() {
        return stageNo;
    }

    /**
     * 设置阶段编号
     */
    public void setStageNo(Integer stageNo) {
        this.stageNo = stageNo;
    }
}