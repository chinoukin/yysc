package com.wisea.yysc.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.trade.OrderInvoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询账期发票Po")
public class OrderInvoPageListPo extends PagePo<OrderInvoPageListVo> {

    @ApiModelProperty(value = "混合搜索条件")
    private String query;
    @ApiModelProperty(value = "发票状态")
    private String invoState;
    @ApiModelProperty(value = "发票类别")
    private String invoType;
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;

    public OrderInvoPageListPo(){

    }

    /**
     * 提交时间开始
     */
    @ApiModelProperty(value = "提交时间开始")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeStart;

    /**
     * 提交时间结束
     */
    @ApiModelProperty(value = "提交时间结束")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime timeEnd;

    public OffsetDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(OffsetDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public OffsetDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(OffsetDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
