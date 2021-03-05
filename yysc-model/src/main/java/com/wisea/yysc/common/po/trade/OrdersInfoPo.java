package com.wisea.yysc.common.po.trade;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单详情信息")
public class OrdersInfoPo extends LongIdPo {

    @ApiModelProperty("当前登录用户类型（0 商家/ 1 买家/ 2 后台/）")
    // @Check(test = {"required", "liveable"} , liveable = {"0", "1", "2"}, liveableMsg = "用户类型只能是1、2、3")
    private String queryUserFlag;

    public String getQueryUserFlag() {
        return queryUserFlag;
    }

    public void setQueryUserFlag(String queryUserFlag) {
        this.queryUserFlag = queryUserFlag;
    }
}
