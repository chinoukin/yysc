package com.wisea.yysc.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询MeasUnitMageVo")
public class MeasUnitMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="编号")
    private String unitNum;

    @ApiModelProperty(value="计量单位名称")
    private String measUnitName;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="计量单位状态（有效、无效）")
    private String effeInvalState;

    @ApiModelProperty(value="所属量纲类型")
    private String dimensionsType;

    @ApiModelProperty(value="换算系数")
    private Double transXs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
    }

    public Double getTransXs() {
        return transXs;
    }

    public void setTransXs(Double transXs) {
        this.transXs = transXs;
    }
}