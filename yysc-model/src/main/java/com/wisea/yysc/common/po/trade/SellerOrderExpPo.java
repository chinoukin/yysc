package com.wisea.yysc.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("订单导出传入参数")
public class SellerOrderExpPo {

    @ApiModelProperty("订单编号")
    private String searchKey;
    @ApiModelProperty(value = "开始日期")
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "结束日期")
    private OffsetDateTime endDate;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }
}
