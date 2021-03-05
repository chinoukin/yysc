package com.wisea.yysc.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * DivideRecordInsertPo
 * 2021/01/26 16:30:07
 */
public class DivideRecordInsertPo {
    /**
     * 订单id
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单id")
    private String ordId;

    /**
     * 商户唯一订单号
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "商户唯一订单号")
    private String outTradeNo;

    /**
     * 交易流水号
     */
    @Check(test = { "maxLength" }, mixLength = 50)
    @ApiModelProperty(value = "交易流水号")
    private String tradeNo;

    /**
     * 唯一请求号
     */
    @Check(test = { "maxLength" }, mixLength = 50)
    @ApiModelProperty(value = "唯一请求号")
    private String outRequestNo;

    /**
     * 分账详情
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "分账详情")
    private String divideDetail;

    /**
     * 分账状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "分账状态")
    private String divideState;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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