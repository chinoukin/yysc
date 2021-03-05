package com.wisea.yysc.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改ApplicationVisitMagePo")
public class ApplicationVisitMagePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="编号")
    private String unitNum;

    @ApiModelProperty(value="应用名称")
    private String applicationName;

    @ApiModelProperty(value="应用类型")
    private String applicationType;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="应用后台地址")
    private String applicationUrl;

    @ApiModelProperty(value="安卓下载地址")
    private String androidLoadUrl;

    @ApiModelProperty(value="安卓二维码下载url")
    private String androidQrLoadUrl;

    @ApiModelProperty(value="苹果下载地址")
    private String appleLoadUrl;

    @ApiModelProperty(value="苹果二维码下载url")
    private String appleQrLoadUrl;

    @ApiModelProperty(value="小程序下载地址")
    private String appletsLoadUrl;

    @ApiModelProperty(value="小程序二维码下载url")
    private String appletsQrLoadUrl;

    @ApiModelProperty(value="web访问地址")
    private String webUrl;

    @ApiModelProperty(value="备注")
    private String remarks;

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

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public String getAndroidLoadUrl() {
        return androidLoadUrl;
    }

    public void setAndroidLoadUrl(String androidLoadUrl) {
        this.androidLoadUrl = androidLoadUrl;
    }

    public String getAndroidQrLoadUrl() {
        return androidQrLoadUrl;
    }

    public void setAndroidQrLoadUrl(String androidQrLoadUrl) {
        this.androidQrLoadUrl = androidQrLoadUrl;
    }

    public String getAppleLoadUrl() {
        return appleLoadUrl;
    }

    public void setAppleLoadUrl(String appleLoadUrl) {
        this.appleLoadUrl = appleLoadUrl;
    }

    public String getAppleQrLoadUrl() {
        return appleQrLoadUrl;
    }

    public void setAppleQrLoadUrl(String appleQrLoadUrl) {
        this.appleQrLoadUrl = appleQrLoadUrl;
    }

    public String getAppletsLoadUrl() {
        return appletsLoadUrl;
    }

    public void setAppletsLoadUrl(String appletsLoadUrl) {
        this.appletsLoadUrl = appletsLoadUrl;
    }

    public String getAppletsQrLoadUrl() {
        return appletsQrLoadUrl;
    }

    public void setAppletsQrLoadUrl(String appletsQrLoadUrl) {
        this.appletsQrLoadUrl = appletsQrLoadUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}