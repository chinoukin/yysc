package com.wisea.yysc.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.yysc.common.vo.EleInvoFileListVo;
import com.wisea.yysc.common.vo.OrdInvoListVo;
import com.wisea.yysc.common.vo.OrdOpreateInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("订单详情Vo")
public class OrdersInfoVo {

    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单状态")
    private String orderStateType;

    @ApiModelProperty("提交订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("支付订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime payOrdDate;

    @ApiModelProperty("付款截止日")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime payDeadLineDate;

    @ApiModelProperty("线下上传凭证日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime uploadPayDate;

    @ApiModelProperty("确认支付审核日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime conFirmPayDate;

    @ApiModelProperty("订单取消日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime ordCancelDate;

    @ApiModelProperty("订单取消原因")
    private String ordCancelName;

    @ApiModelProperty("买家备注")
    private String buyerRemarks;

    /***** 基本信息 *****/
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("订单来源")
    private String sourceType;
    @ApiModelProperty("规格id")
    private Long levelSpecId;
    /**
     * 应用开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "应用开始日期")
    private OffsetDateTime validStartDate;

    /**
     * 应用结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "应用结束日期")
    private OffsetDateTime validEndDate;

    /**** 费用信息 ****/
    @ApiModelProperty("商品列表")
    private CommPubInfosVo commPubInfosVo;
    @ApiModelProperty("发票信息")
    private OrdInvoListVo ordInvo;
    @ApiModelProperty("发票文件列表")
    private List<EleInvoFileListVo> eleInvoList;

    @ApiModelProperty("支付凭证")
    private String eleInvoUrl;

    /**** 购买人信息 ****/
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("买家名称")
    private String buyerCompName;
    @ApiModelProperty("买家联系电话")
    private String buyerPhone;
    @ApiModelProperty("买家公司名称,有就显示没有不显示")
    private String buyerCompany;
    @ApiModelProperty("买家地址")
    private String buyeradderss;

    /**** 支付方式 ****/
    @ApiModelProperty("支付方式")
    private String payMethodType;

    /***** 金额明细 *****/
    @ApiModelProperty("商品总件数")
    private Double commTotalCount;
    @ApiModelProperty("订单总金额")
    private Double amountPayable;
    @ApiModelProperty("应付总金额")
    private Double surePayable;
    @ApiModelProperty("数据库中叫 _ 商品总金额; 暂时使用为 应付款金额")
    private Double commTotalPrice;

    /********************************************/
    @ApiModelProperty("付款截止日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime payDeadDate;
    @ApiModelProperty("当前系统日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime nowDateTime;

    @ApiModelProperty("操作日志信息")
    private List<OrdOpreateInfoListVo> ordOpreateInfoListVoList;

    @ApiModelProperty("支付返回")
    ResultPoJo<Object> poJo;

    @ApiModelProperty("收款方名称")
    private String recipientName;

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public ResultPoJo<Object> getPoJo() {
        return poJo;
    }

    public void setPoJo(ResultPoJo<Object> poJo) {
        this.poJo = poJo;
    }

    public Long getLevelSpecId() {
        return levelSpecId;
    }

    public void setLevelSpecId(Long levelSpecId) {
        this.levelSpecId = levelSpecId;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }

    public List<EleInvoFileListVo> getEleInvoList() {
        return eleInvoList;
    }

    public void setEleInvoList(List<EleInvoFileListVo> eleInvoList) {
        this.eleInvoList = eleInvoList;
    }

    public List<OrdOpreateInfoListVo> getOrdOpreateInfoListVoList() {
        return ordOpreateInfoListVoList;
    }

    public void setOrdOpreateInfoListVoList(List<OrdOpreateInfoListVo> ordOpreateInfoListVoList) {
        this.ordOpreateInfoListVoList = ordOpreateInfoListVoList;
    }

    public OffsetDateTime getValidStartDate() {
        return validStartDate;
    }

    public void setValidStartDate(OffsetDateTime validStartDate) {
        this.validStartDate = validStartDate;
    }

    public OffsetDateTime getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(OffsetDateTime validEndDate) {
        this.validEndDate = validEndDate;
    }

    public OffsetDateTime getPayDeadLineDate() {
        return payDeadLineDate;
    }

    public void setPayDeadLineDate(OffsetDateTime payDeadLineDate) {
        this.payDeadLineDate = payDeadLineDate;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public CommPubInfosVo getCommPubInfosVo() {
        return commPubInfosVo;
    }

    public void setCommPubInfosVo(CommPubInfosVo commPubInfosVo) {
        this.commPubInfosVo = commPubInfosVo;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerCompany() {
        return buyerCompany;
    }

    public void setBuyerCompany(String buyerCompany) {
        this.buyerCompany = buyerCompany;
    }

    public String getBuyeradderss() {
        return buyeradderss;
    }

    public void setBuyeradderss(String buyeradderss) {
        this.buyeradderss = buyeradderss;
    }

    public Double getSurePayable() {
        return surePayable;
    }

    public void setSurePayable(Double surePayable) {
        this.surePayable = surePayable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public OffsetDateTime getUploadPayDate() {
        return uploadPayDate;
    }

    public void setUploadPayDate(OffsetDateTime uploadPayDate) {
        this.uploadPayDate = uploadPayDate;
    }

    public OffsetDateTime getConFirmPayDate() {
        return conFirmPayDate;
    }

    public void setConFirmPayDate(OffsetDateTime conFirmPayDate) {
        this.conFirmPayDate = conFirmPayDate;
    }

    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    public String getOrdCancelName() {
        return ordCancelName;
    }

    public void setOrdCancelName(String ordCancelName) {
        this.ordCancelName = ordCancelName;
    }

    public String getBuyerRemarks() {
        return buyerRemarks;
    }

    public void setBuyerRemarks(String buyerRemarks) {
        this.buyerRemarks = buyerRemarks;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerCompName() {
        return buyerCompName;
    }

    public void setBuyerCompName(String buyerCompName) {
        this.buyerCompName = buyerCompName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public OrdInvoListVo getOrdInvo() {
        return ordInvo;
    }

    public void setOrdInvo(OrdInvoListVo ordInvo) {
        this.ordInvo = ordInvo;
    }

    public Double getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Double commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public OffsetDateTime getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(OffsetDateTime payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public OffsetDateTime getNowDateTime() {
        return nowDateTime;
    }

    public void setNowDateTime(OffsetDateTime nowDateTime) {
        this.nowDateTime = nowDateTime;
    }
}
