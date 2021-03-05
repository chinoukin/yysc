package com.wisea.yysc.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("导出平台端收支明细列表vo")
public class OrderListExpVo {

    @ApiModelProperty("订单编号")
    @ExcelField(title = "订单编号", sort = 1, width = 20)
    private String ordNum;

    /**
     * 提交订单日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交订单日期")
    @ExcelField(title = "提交订单日期", sort = 2, width = 30)
    private OffsetDateTime referOrdDate;

    @ExcelField(title = "用户账号", sort = 3, width = 20)
    @ApiModelProperty(value = "买方名称")
    private String buyerName;

    /**
     * 订单金额
     */
    @ExcelField(title = "订单金额", sort = 4, width = 20)
    @ApiModelProperty(value = "订单金额")
    private Double amountPayable;

    @ExcelField(title = "支付方式", sort = 5, width = 20)
    @ApiModelProperty(value = "支付方式（在线支付、账期支付）")
    private String payMethodType;

    /**
     * 订单来源类型
     */
    @ApiModelProperty(value = "订单来源类型")
    @ExcelField(title = "订单来源", sort = 6, width = 20)
    private String sourceType;

    /**
     * 订单状态类型
     */
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    @ApiModelProperty("订单状态名称")
    @ExcelField(title = "订单类型", sort = 7, width = 20)
    private String orderStateName;

    public String getOrderStateName() {
        return orderStateName;
    }

    public void setOrderStateName(String orderStateName) {
        this.orderStateName = orderStateName;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }
}
