package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * comm_pub_info 表实体
 * 商品发布信息
 * 2021/01/26 16:30:07
 */
public class CommPubInfo extends DataLongEntity<CommPubInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 品类id
     */
    private Long commId;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 商品名称
     */
    private String commTitle;

    /**
     * 应用关联id
     */
    private Long applicationVisitId;

    /**
     * 关键词
     */
    private String recommend;

    /**
     * 支付方式类型
     */
    private String payMethodType;

    /**
     * 商品品牌id
     */
    private Long brandMageId;

    /**
     * 商品发布状态
     */
    private String commStateType;

    /**
     * 应用详情
     */
    private String applicationDetails;

    /**
     * 登录标识
     */
    private String loginType;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

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