package com.wisea.yysc.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("上传支付凭证")
public class EleInvoUploadPo {

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("上传的url")
    private String eleInvoUrl;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }
}
