package com.wisea.yysc.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerGeneratingOrderPo
 * 2018/09/18 17:40:35
 */
@ApiModel("提交生成订单po")
public class BuyerGeneratingOrderPo {

    @ApiModelProperty(value = "发票ID")
    private Long invoId;

    @ApiModelProperty(value = "订单备注")
    private String ordRemarks;

    @ApiModelProperty(value = "支付方式（在线支付、线下支付）")
    private String payMethodType;

    @ApiModelProperty(value = "试用/正式订单的类型")
    @Check(test = "required", requiredMsg = "试用或正式订单的类型不能为空")
    private String tryOrdType;

    @ApiModelProperty(value = "商品id")
    @Check(test = "required", requiredMsg = "购买商品id不能为空")
    private Long commPubId;

    @ApiModelProperty(value = "商品规格id")
    @Check(test = "required", requiredMsg = "商品规格id不能为空")
    private Long levelSpecId;

    @ApiModelProperty(value = "购买数量")
    @Check(test = "required", requiredMsg = "购买数量不能为空")
    private Integer commCount;

    public Long getLevelSpecId() {
        return levelSpecId;
    }

    public void setLevelSpecId(Long levelSpecId) {
        this.levelSpecId = levelSpecId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Integer getCommCount() {
        return commCount;
    }

    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getTryOrdType() {
        return tryOrdType;
    }

    public void setTryOrdType(String tryOrdType) {
        this.tryOrdType = tryOrdType;
    }

    public String getOrdRemarks() {
        return ordRemarks;
    }

    public void setOrdRemarks(String ordRemarks) {
        this.ordRemarks = ordRemarks;
    }

    public Long getInvoId() {
        return invoId;
    }

    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }

}
