package com.wisea.yysc.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页统计信息
 */
@ApiModel("首页统计新")
public class DayStatisticsVo {

    @ApiModelProperty("今日订单量")
    private Integer dayOrdCount;
    @ApiModelProperty("今日销售额")
    private Double daySales;
    @ApiModelProperty("昨日销售额")
    private Double yesterdaySales;
    @ApiModelProperty("近7日销售额")
    private Double nearlySevevSales;

    public Double getNearlySevevSales() {
        return nearlySevevSales;
    }

    public void setNearlySevevSales(Double nearlySevevSales) {
        this.nearlySevevSales = nearlySevevSales;
    }

    public Integer getDayOrdCount() {
        return dayOrdCount;
    }

    public void setDayOrdCount(Integer dayOrdCount) {
        this.dayOrdCount = dayOrdCount;
    }

    public Double getDaySales() {
        return daySales;
    }

    public void setDaySales(Double daySales) {
        this.daySales = daySales;
    }

    public Double getYesterdaySales() {
        return yesterdaySales;
    }

    public void setYesterdaySales(Double yesterdaySales) {
        this.yesterdaySales = yesterdaySales;
    }
}
