package com.wisea.yysc.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改CommAttriMagePo")
public class CommAttriMagePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="属性名称")
    private String commAttriName;

    @ApiModelProperty(value="属性字段")
    private String commAttriColumn;

    @ApiModelProperty(value="属性类型")
    private String commAttriType;

    @ApiModelProperty(value="长度")
    private Integer length;

    @ApiModelProperty(value="商品属性状态（有效、无效）")
    private String effeInvalState;

    @ApiModelProperty(value="小数位")
    private Integer decimalDig;

    @ApiModelProperty(value="最大值")
    private Double maxVal;

    @ApiModelProperty(value="最小值")
    private Double minVal;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="备注")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn;
    }

    public String getCommAttriType() {
        return commAttriType;
    }

    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Integer getDecimalDig() {
        return decimalDig;
    }

    public void setDecimalDig(Integer decimalDig) {
        this.decimalDig = decimalDig;
    }

    public Double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public Double getMinVal() {
        return minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}