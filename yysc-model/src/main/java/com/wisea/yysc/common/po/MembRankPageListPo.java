package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.MembRankPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("会员排行列表参数")
public class MembRankPageListPo extends PagePo<MembRankPageListVo> {

    @ApiModelProperty(value="查询条件(0:最近30天;1:最近90天;为空是全部)")
    private String val;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="开始时间")
    private OffsetDateTime startDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="结束时间")
    private OffsetDateTime endDate;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }
}
