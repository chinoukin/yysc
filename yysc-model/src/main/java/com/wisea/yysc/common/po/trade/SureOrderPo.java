package com.wisea.yysc.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("确认订单信息")
public class SureOrderPo {

    @ApiModelProperty("订单id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
