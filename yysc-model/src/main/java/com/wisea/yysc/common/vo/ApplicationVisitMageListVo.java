package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ApplicationVisitMageListVo
 * 2021/01/26 16:30:07
 */
public class ApplicationVisitMageListVo {
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
     * 应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private String applicationName;

    /**
     * 应用类型
     */
    @ApiModelProperty(value = "应用类型")
    private String applicationType;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 应用后台地址
     */
    @ApiModelProperty(value = "应用后台地址")
    private String applicationUrl;

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
     * 编码+名称
     */
    @ApiModelProperty(value = "编码+名称")
    private String name;

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
     * 获取应用名称
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 设置应用名称
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * 获取应用类型
     */
    public String getApplicationType() {
        return applicationType;
    }

    /**
     * 设置应用类型
     */
    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType == null ? null : applicationType.trim();
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
     * 获取应用后台地址
     */
    public String getApplicationUrl() {
        return applicationUrl;
    }

    /**
     * 设置应用后台地址
     */
    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl == null ? null : applicationUrl.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}