package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommPubInfoInsertPo
 * 2021/01/26 16:30:07
 */
public class CommPubInfoInsertPo {
    /**
     * 品类id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "品类id")
    private Long commId;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 商品名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "商品名称")
    private String commTitle;

    /**
     * 应用关联id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "应用关联id")
    private Long applicationVisitId;

    /**
     * 关键词
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "关键词")
    private String recommend;

    /**
     * 支付方式类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "支付方式类型")
    private String payMethodType;

    /**
     * 商品品牌id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品品牌id")
    private Long brandMageId;

    /**
     * 商品发布状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "商品发布状态")
    private String commStateType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 应用详情
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "应用详情")
    private String applicationDetails;

    /**
     * 获取品类id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置品类id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取商品名称
     */
    public String getCommTitle() {
        return commTitle;
    }

    /**
     * 设置商品名称
     */
    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle == null ? null : commTitle.trim();
    }

    /**
     * 获取应用关联id
     */
    public Long getApplicationVisitId() {
        return applicationVisitId;
    }

    /**
     * 设置应用关联id
     */
    public void setApplicationVisitId(Long applicationVisitId) {
        this.applicationVisitId = applicationVisitId;
    }

    /**
     * 获取关键词
     */
    public String getRecommend() {
        return recommend;
    }

    /**
     * 设置关键词
     */
    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }

    /**
     * 获取支付方式类型
     */
    public String getPayMethodType() {
        return payMethodType;
    }

    /**
     * 设置支付方式类型
     */
    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType == null ? null : payMethodType.trim();
    }

    /**
     * 获取商品品牌id
     */
    public Long getBrandMageId() {
        return brandMageId;
    }

    /**
     * 设置商品品牌id
     */
    public void setBrandMageId(Long brandMageId) {
        this.brandMageId = brandMageId;
    }

    /**
     * 获取商品发布状态
     */
    public String getCommStateType() {
        return commStateType;
    }

    /**
     * 设置商品发布状态
     */
    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType == null ? null : commStateType.trim();
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
     * 获取应用详情
     */
    public String getApplicationDetails() {
        return applicationDetails;
    }

    /**
     * 设置应用详情
     */
    public void setApplicationDetails(String applicationDetails) {
        this.applicationDetails = applicationDetails == null ? null : applicationDetails.trim();
    }
}