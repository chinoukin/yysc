package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.MeasUnitMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * MeasUnitMagePagePo
 * 2021/01/26 16:30:07
 */
public class MeasUnitMagePagePo extends PagePo<MeasUnitMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String unitNum;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称")
    private String measUnitName;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 计量单位状态（有效、无效）
     */
    @ApiModelProperty(value = "计量单位状态（有效、无效）")
    private String effeInvalState;

    /**
     * 所属量纲类型
     */
    @ApiModelProperty(value = "所属量纲类型")
    private String dimensionsType;

    /**
     * 换算系数
     */
    @ApiModelProperty(value = "换算系数")
    private Double transXs;

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