package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * application_visit_mage 表实体
 * 应用访问配置
 * 2021/01/26 16:30:07
 */
public class ApplicationVisitMage extends DataLongEntity<ApplicationVisitMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String unitNum;

    /**
     * 应用名称
     */
    private String applicationName;

    /**
     * 应用类型
     */
    private String applicationType;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 应用后台地址
     */
    private String applicationUrl;

    /**
     * 安卓下载地址
     */
    private String androidLoadUrl;

    /**
     * 安卓二维码下载url
     */
    private String androidQrLoadUrl;

    /**
     * 苹果下载地址
     */
    private String appleLoadUrl;

    /**
     * 苹果二维码下载url
     */
    private String appleQrLoadUrl;

    /**
     * 小程序下载地址
     */
    private String appletsLoadUrl;

    /**
     * 小程序二维码下载url
     */
    private String appletsQrLoadUrl;

    /**
     * web访问地址
     */
    private String webUrl;

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
}