package com.wisea.yysc.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("订单导出返回信息")
public class SellerOrderListVo {

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

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

    @ApiModelProperty(value = "买方名称")
    private String buyerName;

    /**
     * 订单金额
     */
    @ApiModelProperty(value = "订单金额")
    private Double amountPayable;

    /**
     * 订单状态类型
     */
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    @ApiModelProperty("订单状态名称")
    private String orderStateName;

    /**
     * 提交订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交订单日期")
    private OffsetDateTime referOrdDate;

    public String getOrderStateName() {
        return orderStateName;
    }

    public void setOrderStateName(String orderStateName) {
        this.orderStateName = orderStateName;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
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

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
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
