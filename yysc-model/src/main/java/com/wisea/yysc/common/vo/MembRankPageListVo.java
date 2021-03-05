package com.wisea.yysc.common.vo;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("会员排行列表返回值")
public class MembRankPageListVo {

    @ApiModelProperty(value="排行")
    @ExcelField(title = "排行", sort = 10)
    private String rankNum;

    @ApiModelProperty(value="会员账号")
    @ExcelField(title = "会员账号", sort = 20)
    private String registTel;

    @ApiModelProperty(value="会员名称")
    @ExcelField(title = "会员名称", sort = 30)
    private String entpName;

    @ApiModelProperty(value="订单数(单位:个)")
    @ExcelField(title = "订单数(单位:个)", sort = 40)
    private String ordSum;

    @ApiModelProperty(value="购物金额")
    @ExcelField(title = "购物金额", sort = 50)
    private Double commTotalPrice;

    public String getRankNum() {
        return rankNum;
    }

    public void setRankNum(String rankNum) {
        this.rankNum = rankNum;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getOrdSum() {
        return ordSum;
    }

    public void setOrdSum(String ordSum) {
        this.ordSum = ordSum;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }
}
