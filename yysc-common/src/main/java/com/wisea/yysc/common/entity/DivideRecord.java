package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * divide_record 表实体
 * 分账记录
 * 2021/01/26 16:30:07
 */
public class DivideRecord extends DataLongEntity<DivideRecord> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String ordId;

    /**
     * 商户唯一订单号
     */
    private String outTradeNo;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 唯一请求号
     */
    private String outRequestNo;

    /**
     * 分账详情
     */
    private String divideDetail;

    /**
     * 分账状态
     */
    private String divideState;

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
     * 获取分账详情
     */
    public String getDivideDetail() {
        return divideDetail;
    }

    /**
     * 设置分账详情
     */
    public void setDivideDetail(String divideDetail) {
        this.divideDetail = divideDetail == null ? null : divideDetail.trim();
    }

    /**
     * 获取分账状态
     */
    public String getDivideState() {
        return divideState;
    }

    /**
     * 设置分账状态
     */
    public void setDivideState(String divideState) {
        this.divideState = divideState == null ? null : divideState.trim();
    }
}