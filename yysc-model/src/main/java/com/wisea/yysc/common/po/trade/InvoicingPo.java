package com.wisea.yysc.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("开具发票传入的参数")
public class InvoicingPo {

    @ApiModelProperty(value = "发票的id")
    private Long invoId;

    @ApiModelProperty("发票传0,支付凭证传 1")
    private String fileType;

    /**
     * 上传电子发片的图片地址
     */
    @ApiModelProperty(value = "上传电子发票的图片地址")
    private String eleInvoUrl;

    /**
     * 发票的状态
     */
    private String invoState;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getInvoId() {
        return invoId;
    }

    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }
}
