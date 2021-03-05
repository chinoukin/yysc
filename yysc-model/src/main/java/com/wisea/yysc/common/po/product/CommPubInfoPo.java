package com.wisea.yysc.common.po.product;

import com.wisea.yysc.common.po.CommAttriListPo;
import com.wisea.yysc.common.po.CommPictureListPo;
import com.wisea.yysc.common.po.LevelSpecQuoteListPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("新增或修改CommPubInfoPo")
public class CommPubInfoPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="品类id，新增修改应用之前只传该值")
    private Long commId;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="商品名称")
    private String commTitle;

    @ApiModelProperty(value="应用详情")
    private String applicationDetails;

    @ApiModelProperty(value="应用关联id")
    private Long applicationVisitId;

    @ApiModelProperty(value="关键词")
    private String recommend;

    @ApiModelProperty(value="支付方式类型")
    private String payMethodType;


    @ApiModelProperty(value="商品发布状态")
    private String commStateType;

    @ApiModelProperty(value="商品属性")
    private List<CommAttriListPo> commAttriListPos;


    @ApiModelProperty(value="售卖规格")
    private List<LevelSpecQuoteListPo> levelSpecQuoteListPos;

    @ApiModelProperty(value="图片")
    private List<CommPictureListPo> commPictureListPos;

    public String getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(String applicationDetails) {
        this.applicationDetails = applicationDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<LevelSpecQuoteListPo> getLevelSpecQuoteListPos() {
        return levelSpecQuoteListPos;
    }

    public void setLevelSpecQuoteListPos(List<LevelSpecQuoteListPo> levelSpecQuoteListPos) {
        this.levelSpecQuoteListPos = levelSpecQuoteListPos;
    }

    public List<CommAttriListPo> getCommAttriListPos() {
        return commAttriListPos;
    }

    public void setCommAttriListPos(List<CommAttriListPo> commAttriListPos) {
        this.commAttriListPos = commAttriListPos;
    }

    public List<CommPictureListPo> getCommPictureListPos() {
        return commPictureListPos;
    }

    public void setCommPictureListPos(List<CommPictureListPo> commPictureListPos) {
        this.commPictureListPos = commPictureListPos;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }
}