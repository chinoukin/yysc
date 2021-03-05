package com.wisea.yysc.common.po.product;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.product.CommPubInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CommPubInfoPo")
public class CommPubInfoPageListPo extends PagePo<CommPubInfoPageListVo> {

    @ApiModelProperty(value="搜索框数据")
    private String standardTypeQuery;

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


    public String getStandardTypeQuery() {
        return standardTypeQuery;
    }

    public void setStandardTypeQuery(String standardTypeQuery) {
        this.standardTypeQuery = standardTypeQuery;
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