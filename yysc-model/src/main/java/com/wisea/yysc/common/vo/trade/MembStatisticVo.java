package com.wisea.yysc.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户统计返回值")
public class MembStatisticVo {

    @ApiModelProperty(value="会员总数")
    private Integer totalCount;
    @ApiModelProperty(value="本月会员新增数")
    private Integer monthCount;
    @ApiModelProperty(value="昨日会员新增数")
    private Integer yesterdayCount;
    @ApiModelProperty(value="今日新增数")
    private Integer dayCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    public Integer getYesterdayCount() {
        return yesterdayCount;
    }

    public void setYesterdayCount(Integer yesterdayCount) {
        this.yesterdayCount = yesterdayCount;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }
}
