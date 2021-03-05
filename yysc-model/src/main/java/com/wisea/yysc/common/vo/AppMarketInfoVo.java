package com.wisea.yysc.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("应用市场信息设置信息")
public class AppMarketInfoVo {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 平台名称
     */
    @ApiModelProperty(value = "平台名称")
    private String platformName;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    /**
     * 客服热线
     */
    @ApiModelProperty(value = "客服热线")
    private String custService;

    /**
     * 店铺地址
     */
    @ApiModelProperty(value = "店铺地址")
    private String shopUrl;

    /**
     * 客服邮箱
     */
    @ApiModelProperty(value = "客服邮箱")
    private String custEmail;

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
    public String getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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
