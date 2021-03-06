package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataEntity;

/**
 * app_market_info 表实体
 * 应用市场信息
 * 2021/01/26 16:30:07
 */
public class AppMarketInfo extends DataEntity<AppMarketInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 客服热线
     */
    private String custService;

    /**
     * 店铺地址
     */
    private String shopUrl;

    /**
     * 客服邮箱
     */
    private String custEmail;

    /**
     * 获取平台名称
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * 设置平台名称
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    /**
     * 获取店铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置店铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取客服热线
     */
    public String getCustService() {
        return custService;
    }

    /**
     * 设置客服热线
     */
    public void setCustService(String custService) {
        this.custService = custService == null ? null : custService.trim();
    }

    /**
     * 获取店铺地址
     */
    public String getShopUrl() {
        return shopUrl;
    }

    /**
     * 设置店铺地址
     */
    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl == null ? null : shopUrl.trim();
    }

    /**
     * 获取客服邮箱
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * 设置客服邮箱
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }
}