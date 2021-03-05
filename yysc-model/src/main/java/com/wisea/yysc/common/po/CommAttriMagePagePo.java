package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.CommAttriMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommAttriMagePagePo
 * 2021/01/26 16:30:07
 */
public class CommAttriMagePagePo extends PagePo<CommAttriMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "属性id")
    private Long id;

    /**
     * 属性名称
     */
    @ApiModelProperty(value = "属性名称")
    private String commAttriName;

    /**
     * 属性字段
     */
    @ApiModelProperty(value = "属性字段")
    private String commAttriColumn;

    /**
     * 属性类型
     */
    @ApiModelProperty(value = "属性类型")
    private String commAttriType;

    /**
     * 长度
     */
    @ApiModelProperty(value = "长度")
    private Integer length;

    /**
     * 商品属性状态（有效、无效）
     */
    @ApiModelProperty(value = "商品属性状态（有效、无效）")
    private String effeInvalState;

    /**
     * 小数位
     */
    @ApiModelProperty(value = "小数位")
    private Integer decimalDig;

    /**
     * 最大值
     */
    @ApiModelProperty(value = "最大值")
    private Double maxVal;

    /**
     * 最小值
     */
    @ApiModelProperty(value = "最小值")
    private Double minVal;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

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
     * 字典值
     */
    @ApiModelProperty(value = "字典值")
    private String dictVal;

    /**
     * 获取属性id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置属性id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取属性名称
     */
    public String getCommAttriName() {
        return commAttriName;
    }

    /**
     * 设置属性名称
     */
    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName == null ? null : commAttriName.trim();
    }

    /**
     * 获取属性字段
     */
    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    /**
     * 设置属性字段
     */
    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn == null ? null : commAttriColumn.trim();
    }

    /**
     * 获取属性类型
     */
    public String getCommAttriType() {
        return commAttriType;
    }

    /**
     * 设置属性类型
     */
    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType == null ? null : commAttriType.trim();
    }

    /**
     * 获取长度
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 设置长度
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 获取商品属性状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置商品属性状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
    }

    /**
     * 获取小数位
     */
    public Integer getDecimalDig() {
        return decimalDig;
    }

    /**
     * 设置小数位
     */
    public void setDecimalDig(Integer decimalDig) {
        this.decimalDig = decimalDig;
    }

    /**
     * 获取最大值
     */
    public Double getMaxVal() {
        return maxVal;
    }

    /**
     * 设置最大值
     */
    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    /**
     * 获取最小值
     */
    public Double getMinVal() {
        return minVal;
    }

    /**
     * 设置最小值
     */
    public void setMinVal(Double minVal) {
        this.minVal = minVal;
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

    /**
     * 获取字典值
     */
    public String getDictVal() {
        return dictVal;
    }

    /**
     * 设置字典值
     */
    public void setDictVal(String dictVal) {
        this.dictVal = dictVal == null ? null : dictVal.trim();
    }
}