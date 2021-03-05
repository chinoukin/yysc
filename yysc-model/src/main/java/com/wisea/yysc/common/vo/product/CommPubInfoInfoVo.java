package com.wisea.yysc.common.vo.product;

import com.wisea.yysc.common.vo.AppMarketInfoVo;
import com.wisea.yysc.common.vo.CommAttriListVo;
import com.wisea.yysc.common.vo.CommPictureListVo;
import com.wisea.yysc.common.vo.LevelSpecQuoteListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("CommPubInfo详细信息Vo")
public class CommPubInfoInfoVo {
    @ApiModelProperty(value="id")
    private String id;

    @ApiModelProperty(value="品类id")
    private Long commId;

    @ApiModelProperty(value="会员id")
    private Long membId;

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

    @ApiModelProperty(value="应用详情")
    private String applicationDetails;

    @ApiModelProperty(value="最高价格")
    private Double maxPrice;

    @ApiModelProperty(value="最低价格")
    private Double minPrice;

    @ApiModelProperty(value="图片")
    private List<CommPictureListVo> pictures;

    @ApiModelProperty(value="售卖规格")
    private List<LevelSpecQuoteListVo> levelSpecQuotes;

    @ApiModelProperty(value="商品属性")
    private List<CommAttriListVo> commAttris;

    @ApiModelProperty(value = "前台-应用市场信息")
    AppMarketInfoVo appMarketInfo;

    @ApiModelProperty(value="前台-推荐产品")
    private List<CommPubInfoPageListVo> commPubInfos;

    public AppMarketInfoVo getAppMarketInfo() {
        return appMarketInfo;
    }

    public void setAppMarketInfo(AppMarketInfoVo appMarketInfo) {
        this.appMarketInfo = appMarketInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<CommPictureListVo> getPictures() {
        return pictures;
    }

    public void setPictures(List<CommPictureListVo> pictures) {
        this.pictures = pictures;
    }

    public List<LevelSpecQuoteListVo> getLevelSpecQuotes() {
        return levelSpecQuotes;
    }

    public void setLevelSpecQuotes(List<LevelSpecQuoteListVo> levelSpecQuotes) {
        this.levelSpecQuotes = levelSpecQuotes;
    }

    public List<CommAttriListVo> getCommAttris() {
        return commAttris;
    }

    public void setCommAttris(List<CommAttriListVo> commAttris) {
        this.commAttris = commAttris;
    }

    public List<CommPubInfoPageListVo> getCommPubInfos() {
        return commPubInfos;
    }

    public void setCommPubInfos(List<CommPubInfoPageListVo> commPubInfos) {
        this.commPubInfos = commPubInfos;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(String applicationDetails) {
        this.applicationDetails = applicationDetails;
    }
}