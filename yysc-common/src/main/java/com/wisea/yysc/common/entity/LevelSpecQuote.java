package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * level_spec_quote 表实体
 * 售卖规格
 * 2021/01/26 16:30:07
 */
public class LevelSpecQuote extends DataLongEntity<LevelSpecQuote> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 是否允许试用标志
     */
    private String sfyxsyFlag;

    /**
     * 试用天数
     */
    private Integer trialDays;

    /**
     * 售卖周期类型
     */
    private String dimensionsType;

    /**
     * 价格
     */
    private Double price;

    /**
     * 计量单位id
     */
    private Long measUnitId;

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取规格名称
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 设置规格名称
     */
    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    /**
     * 获取是否允许试用标志
     */
    public String getSfyxsyFlag() {
        return sfyxsyFlag;
    }

    /**
     * 设置是否允许试用标志
     */
    public void setSfyxsyFlag(String sfyxsyFlag) {
        this.sfyxsyFlag = sfyxsyFlag == null ? null : sfyxsyFlag.trim();
    }

    /**
     * 获取试用天数
     */
    public Integer getTrialDays() {
        return trialDays;
    }

    /**
     * 设置试用天数
     */
    public void setTrialDays(Integer trialDays) {
        this.trialDays = trialDays;
    }

    /**
     * 获取售卖周期类型
     */
    public String getDimensionsType() {
        return dimensionsType;
    }

    /**
     * 设置售卖周期类型
     */
    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType == null ? null : dimensionsType.trim();
    }

    /**
     * 获取价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}