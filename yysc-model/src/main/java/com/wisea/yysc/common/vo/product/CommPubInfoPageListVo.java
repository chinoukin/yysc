package com.wisea.yysc.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CommPubInfoVo")
public class CommPubInfoPageListVo {
    @ApiModelProperty(value="id")
    private String id;

    @ApiModelProperty(value="品类id")
    private Long commId;

    @ApiModelProperty(value="应用编号")
    private String unitNum;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="销量")
    private Double volume;

    @ApiModelProperty(value="低价格")
    private Double MinPrice;

    @ApiModelProperty(value="高价格")
    private Double MaxPrice;

    @ApiModelProperty(value="商品图片地址")
    private String pictureUrl;

    @ApiModelProperty(value="商品名称")
    private String commTitle;

    @ApiModelProperty(value="应用关联id")
    private Long applicationVisitId;

    @ApiModelProperty(value="关键词")
    private String recommend;

    @ApiModelProperty(value="支付方式类型")
    private String payMethodType;

    @ApiModelProperty(value="商品品牌id")
    private Long brandMageId;

    @ApiModelProperty(value="商品发布状态")
    private String commStateType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(Double minPrice) {
        MinPrice = minPrice;
    }

    public Double getMaxPrice() {
        return MaxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        MaxPrice = maxPrice;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getApplicationVisitId() {
        return applicationVisitId;
    }

    public void setApplicationVisitId(Long applicationVisitId) {
        this.applicationVisitId = applicationVisitId;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public Long getBrandMageId() {
        return brandMageId;
    }

    public void setBrandMageId(Long brandMageId) {
        this.brandMageId = brandMageId;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }
}