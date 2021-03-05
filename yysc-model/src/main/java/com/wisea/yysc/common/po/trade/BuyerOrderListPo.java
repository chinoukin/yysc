package com.wisea.yysc.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.trade.BuyerInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("订单列表传入参数")
public class BuyerOrderListPo extends PagePo<BuyerInfoListVo> {


    /**
     * 订单状态类型
     */
    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 类型id
     */
    @ApiModelProperty(value = "类型id")
    private Long orderTypeId;

    /**
     * 提交时间开始
     */
    @ApiModelProperty(value = "提交时间开始")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeStart;

    /**
     * 提交时间结束
     */
    @ApiModelProperty(value = "提交时间结束")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeEnd;

    @ApiModelProperty("品类名称")
    private String commCatgName;

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public Long getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Long orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(OffsetDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public OffsetDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(OffsetDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
