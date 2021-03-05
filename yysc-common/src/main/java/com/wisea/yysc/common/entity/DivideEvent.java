package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * divide_event 表实体
 * 分账事件
 * 2021/01/26 16:30:07
 */
public class DivideEvent extends DataLongEntity<DivideEvent> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String ordId;

    /**
     * 分账详情
     */
    private String divideDetail;

    /**
     * 分账开始时间
     */
    private OffsetDateTime divStartTime;

    /**
     * 执行状态
     */
    private String exeState;

    /**
     * 是否首付款标识
     */
    private String sfsfkFlag;

    /**
     * 订单日期id
     */
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