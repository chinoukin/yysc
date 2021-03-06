package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * DivideEventInsertPo
 * 2021/01/26 16:30:07
 */
public class DivideEventInsertPo {
    /**
     * 订单id
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单id")
    private String ordId;

    /**
     * 分账详情
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "分账详情")
    private String divideDetail;

    /**
     * 分账开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "分账开始时间")
    private OffsetDateTime divStartTime;

    /**
     * 执行状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "执行状态")
    private String exeState;

    /**
     * 是否首付款标识
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "是否首付款标识")
    private String sfsfkFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 订单日期id
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单日期id")
    private String ordDateId;

    /**
     * 获取订单id
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }

    /**
     * 获取分账详情
     */
    public String getDivideDetail() {
        return divideDetail;
    }

    /**
     * 设置分账详情
     */
    public void setDivideDetail(String divideDetail) {
        this.divideDetail = divideDetail == null ? null : divideDetail.trim();
    }

    /**
     * 获取分账开始时间
     */
    public OffsetDateTime getDivStartTime() {
        return divStartTime;
    }

    /**
     * 设置分账开始时间
     */
    public void setDivStartTime(OffsetDateTime divStartTime) {
        this.divStartTime = divStartTime;
    }

    /**
     * 获取执行状态
     */
    public String getExeState() {
        return exeState;
    }

    /**
     * 设置执行状态
     */
    public void setExeState(String exeState) {
        this.exeState = exeState == null ? null : exeState.trim();
    }

    /**
     * 获取是否首付款标识
     */
    public String getSfsfkFlag() {
        return sfsfkFlag;
    }

    /**
     * 设置是否首付款标识
     */
    public void setSfsfkFlag(String sfsfkFlag) {
        this.sfsfkFlag = sfsfkFlag == null ? null : sfsfkFlag.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取订单日期id
     */
    public String getOrdDateId() {
        return ordDateId;
    }

    /**
     * 设置订单日期id
     */
    public void setOrdDateId(String ordDateId) {
        this.ordDateId = ordDateId == null ? null : ordDateId.trim();
    }
}