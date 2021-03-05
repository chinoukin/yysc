package com.wisea.yysc.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * 提交订单返回订单信息
 */
@ApiModel("提交订单返回订单信息")
public class BuyerGeneratingOrderVo {

    @ApiModelProperty("订单总金额")
    private double amountPayable;

    @ApiModelProperty("商品总数量")
    private Integer totalCount;

    @ApiModelProperty("商品名称")
    private String commPubName;

    @ApiModelProperty("订单编号")
    private String orderNum;

    @ApiModelProperty("收款方名称")
    private String recipientName;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交订单日期")
    private OffsetDateTime referOrdDate;

    @ApiModelProperty("订单期限")
    private Integer limitTime;

    /**
     * 付款截止日
     */
    @ApiModelProperty("付款截止日")
    private OffsetDateTime payDeadLineDate;

    @ApiModelProperty("支付返回")
    ResultPoJo<Object> poJo;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String acctNum;

    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    private String bankDeposit;

    public OffsetDateTime getPayDeadLineDate() {
        return payDeadLineDate;
    }

    public void setPayDeadLineDate(OffsetDateTime payDeadLineDate) {
        this.payDeadLineDate = payDeadLineDate;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getBankDeposit() {
        return bankDeposit;
    }

    public void setBankDeposit(String bankDeposit) {
        this.bankDeposit = bankDeposit;
    }

    public ResultPoJo<Object> getPoJo() {
        return poJo;
    }

    public void setPoJo(ResultPoJo<Object> poJo) {
        this.poJo = poJo;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getCommPubName() {
        return commPubName;
    }

    public void setCommPubName(String commPubName) {
        this.commPubName = commPubName;
    }

}
