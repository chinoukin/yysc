package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * LevelSpecQuoteListPo
 * 2021/01/26 16:30:07
 */
public class LevelSpecQuoteListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 规格名称
     */
    @Check(test = "required", requiredMsg = "规格名称不能为空")
    @ApiModelProperty(value = "规格名称")
    private String specName;

    /**
     * 是否允许试用标志
     */
    @Check(test = "required", requiredMsg = "是否允许试用标志不能为空")
    @ApiModelProperty(value = "是否允许试用标志")
    private String sfyxsyFlag;

    /**
     * 试用天数
     */
    @Check(test = "required", requiredMsg = "试用天数不能为空")
    @ApiModelProperty(value = "试用天数")
    private Integer trialDays;

    /**
     * 售卖周期类型
     */
    @Check(test = "required", requiredMsg = "售卖周期类型不能为空")
    @ApiModelProperty(value = "售卖周期类型")
    private String dimensionsType;

    /**
     * 价格
     */
    @Check(test = "required", requiredMsg = "价格不能为空")
    @ApiModelProperty(value = "价格")
    private Double price;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 计量单位id
     */
    @Check(test = "required", requiredMsg = "计量单位id不能为空")
    @ApiModelProperty(value = "计量单位id")
    private Long measUnitId;

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }


    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}