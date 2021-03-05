package com.wisea.yysc.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单中商品信息")
public class CommPubInfosVo {

    @ApiModelProperty("商品图片")
    private String commPubUrl;

    @ApiModelProperty("商品名称")
    private String commPubName;

    @ApiModelProperty("商品货号")
    private String commPubNumber;

    @ApiModelProperty("商品价格")
    private Double commPrice;

    @ApiModelProperty("商品数量")
    private Integer commPubSize;

    @ApiModelProperty("商品单位id")
    private Long commPubMeauntId;

    @ApiModelProperty("商品单位名称")
    private Long commPubMeauntName;

    @ApiModelProperty("商品规格")
    private String commPubDesc;

    @ApiModelProperty("规格id")
    private Long commSpecId;

    public Long getCommSpecId() {
        return commSpecId;
    }

    public void setCommSpecId(Long commSpecId) {
        this.commSpecId = commSpecId;
    }

    public String getCommPubUrl() {
        return commPubUrl;
    }

    public void setCommPubUrl(String commPubUrl) {
        this.commPubUrl = commPubUrl;
    }

    public String getCommPubName() {
        return commPubName;
    }

    public void setCommPubName(String commPubName) {
        this.commPubName = commPubName;
    }

    public String getCommPubNumber() {
        return commPubNumber;
    }

    public void setCommPubNumber(String commPubNumber) {
        this.commPubNumber = commPubNumber;
    }

    public Double getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(Double commPrice) {
        this.commPrice = commPrice;
    }

    public Integer getCommPubSize() {
        return commPubSize;
    }

    public void setCommPubSize(Integer commPubSize) {
        this.commPubSize = commPubSize;
    }

    public Long getCommPubMeauntId() {
        return commPubMeauntId;
    }

    public void setCommPubMeauntId(Long commPubMeauntId) {
        this.commPubMeauntId = commPubMeauntId;
    }

    public Long getCommPubMeauntName() {
        return commPubMeauntName;
    }

    public void setCommPubMeauntName(Long commPubMeauntName) {
        this.commPubMeauntName = commPubMeauntName;
    }

    public String getCommPubDesc() {
        return commPubDesc;
    }

    public void setCommPubDesc(String commPubDesc) {
        this.commPubDesc = commPubDesc;
    }
}
