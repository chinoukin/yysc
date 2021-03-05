package com.wisea.yysc.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("取消订单传入参数")
public class OrderCancelPo {

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("订单取消原因的id,取后台配置")
    private Long orderCanceId;

    @ApiModelProperty("取消的操作备注")
    private String orderRemark;

    public Long getOrderCanceId() {
        return orderCanceId;
    }

    public void setOrderCanceId(Long orderCanceId) {
        this.orderCanceId = orderCanceId;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
