package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * BrandMageUpdatePo
 * 2021/01/26 16:30:07
 */
public class BrandMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 序号
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "序号")
    private String serialNum;

    /**
     * 品牌logo
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品牌logo")
    private String brandLogo;

    /**
     * 品牌名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    /**
     * 品牌故事
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
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
     * 获取序号
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * 设置序号
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    /**
     * 获取品牌logo
     */
    public String getBrandLogo() {
        return brandLogo;
    }

    /**
     * 设置品牌logo
     */
    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    /**
     * 获取品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取品牌故事
     */
    public String getBrandStory() {
        return brandStory;
    }

    /**
     * 设置品牌故事
     */
    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory == null ? null : brandStory.trim();
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
}