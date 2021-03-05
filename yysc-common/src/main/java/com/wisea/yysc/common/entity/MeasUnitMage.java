package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * meas_unit_mage 表实体
 * 计量单位管理
 * 2021/01/26 16:30:07
 */
public class MeasUnitMage extends DataLongEntity<MeasUnitMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String unitNum;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 计量单位状态（有效、无效）
     */
    private String effeInvalState;

    /**
     * 所属量纲类型
     */
    private String dimensionsType;

    /**
     * 换算系数
     */
    private Double transXs;

    /**
     * 获取编号
     */
    public String getUnitNum() {
        return unitNum;
    }

    /**
     * 设置编号
     */
    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum == null ? null : unitNum.trim();
    }

    /**
     * 获取计量单位名称
     */
    public String getMeasUnitName() {
        return measUnitName;
    }

    /**
     * 设置计量单位名称
     */
    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName == null ? null : measUnitName.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取计量单位状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置计量单位状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
    }

    /**
     * 获取所属量纲类型
     */
    public String getDimensionsType() {
        return dimensionsType;
    }

    /**
     * 设置所属量纲类型
     */
    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType == null ? null : dimensionsType.trim();
    }

    /**
     * 获取换算系数
     */
    public Double getTransXs() {
        return transXs;
    }

    /**
     * 设置换算系数
     */
    public void setTransXs(Double transXs) {
        this.transXs = transXs;
    }
}