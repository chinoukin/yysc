package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.IncomeDetailListVo;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * IncomeDetailPagePo
 * 2021/01/26 16:30:07
 */
public class IncomeDetailPagePo extends PagePo<IncomeDetailListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 交易流水号
     */
    @ApiModelProperty(value = "交易流水号")
    private String tradeNo;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 完成时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "完成时间")
    private OffsetDateTime finishDate;

    /**
     * 订单总金额
     */
    @ApiModelProperty(value = "订单总金额")
    private Double commTotalPrice;

    /**
     * 分账收入
     */
    @ApiModelProperty(value = "分账收入")
    private Double splitIncome;

    /**
     * 账单编号
     */
    @ApiModelProperty(value = "账单编号")
    private String settleBillNumb;

    /**
     * 订单运费
     */
    @ApiModelProperty(value = "订单运费")
    private Double ordFreight;

    /**
     * 退货退款金额
     */
    @ApiModelProperty(value = "退货退款金额")
    private Double refundPrice;

    /**
     * 运营服务费
     */
    @ApiModelProperty(value = "运营服务费")
    private Double operSerCharge;

    /**
     * 技术服务费
     */
    @ApiModelProperty(value = "技术服务费")
    private Double jsSerCost;

    /**
     * 订单来源类型
     */
    @ApiModelProperty(value = "订单来源类型")
    private String ordSourceType;

    /**
     * 订单结算单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单结算单id")
    private Long settOrdId;

    /**
     * 买家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买家id")
    private Long buyerId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    /**
     * 获取完成时间
     */
    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    /**
     * 设置完成时间
     */
    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * 获取订单总金额
     */
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    /**
     * 设置订单总金额
     */
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    /**
     * 获取分账收入
     */
    public Double getSplitIncome() {
        return splitIncome;
    }

    /**
     * 设置分账收入
     */
    public void setSplitIncome(Double splitIncome) {
        this.splitIncome = splitIncome;
    }

    /**
     * 获取账单编号
     */
    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    /**
     * 设置账单编号
     */
    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb == null ? null : settleBillNumb.trim();
    }

    /**
     * 获取订单运费
     */
    public Double getOrdFreight() {
        return ordFreight;
    }

    /**
     * 设置订单运费
     */
    public void setOrdFreight(Double ordFreight) {
        this.ordFreight = ordFreight;
    }

    /**
     * 获取退货退款金额
     */
    public Double getRefundPrice() {
        return refundPrice;
    }

    /**
     * 设置退货退款金额
     */
    public void setRefundPrice(Double refundPrice) {
        this.refundPrice = refundPrice;
    }

    /**
     * 获取运营服务费
     */
    public Double getOperSerCharge() {
        return operSerCharge;
    }

    /**
     * 设置运营服务费
     */
    public void setOperSerCharge(Double operSerCharge) {
        this.operSerCharge = operSerCharge;
    }

    /**
     * 获取技术服务费
     */
    public Double getJsSerCost() {
        return jsSerCost;
    }

    /**
     * 设置技术服务费
     */
    public void setJsSerCost(Double jsSerCost) {
        this.jsSerCost = jsSerCost;
    }

    /**
     * 获取订单来源类型
     */
    public String getOrdSourceType() {
        return ordSourceType;
    }

    /**
     * 设置订单来源类型
     */
    public void setOrdSourceType(String ordSourceType) {
        this.ordSourceType = ordSourceType == null ? null : ordSourceType.trim();
    }

    /**
     * 获取订单结算单id
     */
    public Long getSettOrdId() {
        return settOrdId;
    }

    /**
     * 设置订单结算单id
     */
    public void setSettOrdId(Long settOrdId) {
        this.settOrdId = settOrdId;
    }

    /**
     * 获取买家id
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买家id
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}