package com.wisea.yysc.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("修改报价PO")
public class UpdateQuotedPo {

    @ApiModelProperty("订单ID")
    private Long ordId;
    @ApiModelProperty("订单总金额")
    private Double weightPrice;
    @ApiModelProperty("订单备注信息")
    private String orderReamrk;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Double getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(Double weightPrice) {
        this.weightPrice = weightPrice;
    }

    public String getOrderReamrk() {
        return orderReamrk;
    }

    public void setOrderReamrk(String orderReamrk) {
        this.orderReamrk = orderReamrk;
    }
}
