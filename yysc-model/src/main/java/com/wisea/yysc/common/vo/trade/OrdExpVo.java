package com.wisea.yysc.common.vo.trade;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("财务订单统计导出")
public class OrdExpVo {

    @ExcelField(title = "有效订单数总数", sort = 2, width = 20)
    @ApiModelProperty(value = "有效订单数")
    private Integer effOrdCount;
    @ExcelField(title = "有效订单总额", sort = 3, width = 20)
    @ApiModelProperty(value = "有效订单总额")
    private Double effOrdAmount;
    @ExcelField(title = "无效订单数总数", sort = 4, width = 20)
    @ApiModelProperty(value = "无效订单数")
    private Integer notEffOrdCount;
    @ExcelField(title = "无效订单数总额", sort = 5, width = 20)
    @ApiModelProperty(value = "无效订单总额")
    private Double notEffOrdAmount;
    @ExcelField(title = "已完成订单数总数", sort = 6, width = 20)
    @ApiModelProperty(value = "已完成订单数")
    private Integer overOrdCount;
    @ExcelField(title = "已完成订单数总额", sort = 7, width = 20)
    @ApiModelProperty(value = "已完成订单总额")
    private Double overOrdAmount;
    @ExcelField(title = "销售总额", sort = 1, width = 20)
    @ApiModelProperty(value = "销售总额")
    private Double totalOrdAmount;

    public Integer getEffOrdCount() {
        return effOrdCount;
    }

    public void setEffOrdCount(Integer effOrdCount) {
        this.effOrdCount = effOrdCount;
    }

    public Double getEffOrdAmount() {
        return effOrdAmount;
    }

    public void setEffOrdAmount(Double effOrdAmount) {
        this.effOrdAmount = effOrdAmount;
    }

    public Integer getNotEffOrdCount() {
        return notEffOrdCount;
    }

    public void setNotEffOrdCount(Integer notEffOrdCount) {
        this.notEffOrdCount = notEffOrdCount;
    }

    public Double getNotEffOrdAmount() {
        return notEffOrdAmount;
    }

    public void setNotEffOrdAmount(Double notEffOrdAmount) {
        this.notEffOrdAmount = notEffOrdAmount;
    }

    public Integer getOverOrdCount() {
        return overOrdCount;
    }

    public void setOverOrdCount(Integer overOrdCount) {
        this.overOrdCount = overOrdCount;
    }

    public Double getOverOrdAmount() {
        return overOrdAmount;
    }

    public void setOverOrdAmount(Double overOrdAmount) {
        this.overOrdAmount = overOrdAmount;
    }

    public Double getTotalOrdAmount() {
        return totalOrdAmount;
    }

    public void setTotalOrdAmount(Double totalOrdAmount) {
        this.totalOrdAmount = totalOrdAmount;
    }
}
