package com.wisea.yysc.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("LevelSpecQuote详细信息Vo")
public class LevelSpecQuoteInfoVo {
    @ApiModelProperty(value="商品发布id")
    private Long commPubId;

    @ApiModelProperty(value="规格名称")
    private String specName;

    @ApiModelProperty(value="是否允许试用标志")
    private String sfyxsyFlag;

    @ApiModelProperty(value="试用天数")
    private Integer trialDays;

    @ApiModelProperty(value="售卖周期类型")
    private String dimensionsType;

    @ApiModelProperty(value="价格")
    private Double price;

    @ApiModelProperty(value="计量单位id")
    private Long measUnitId;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSfyxsyFlag() {
        return sfyxsyFlag;
    }

    public void setSfyxsyFlag(String sfyxsyFlag) {
        this.sfyxsyFlag = sfyxsyFlag;
    }

    public Integer getTrialDays() {
        return trialDays;
    }

    public void setTrialDays(Integer trialDays) {
        this.trialDays = trialDays;
    }

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMeasUnitId() {
        return measUnitId;
    }

    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }
}