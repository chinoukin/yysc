package com.wisea.yysc.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ApplicationVisitMageInsertPo
 * 2021/01/26 16:30:07
 */
public class ApplicationVisitMageInsertPo {
    /**
     * 编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "编号")
    private String unitNum;

    /**
     * 应用名称
     */
    @Check(test = { "maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "应用名称")
    private String applicationName;

    /**
     * 应用类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "应用类型")
    private String applicationType;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 应用后台地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "应用后台地址")
    private String applicationUrl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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
}