package com.wisea.yysc.common.vo.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrderStatisticsVo
 * @date 2020/5/26 9:38
 * @Description
 */
public class OrderStatisticsVo {
    @ApiModelProperty("待付款")
    private Integer paymentCount;
    @ApiModelProperty("已完成")
    private Integer completCount;
    @ApiModelProperty("已取消")
    private Integer cancelCount;

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public Integer getCompletCount() {
        return completCount;
    }

    public void setCompletCount(Integer completCount) {
        this.completCount = completCount;
    }

    public Integer getCancelCount() {
        return cancelCount;
    }

    public void setCancelCount(Integer cancelCount) {
        this.cancelCount = cancelCount;
    }
}
