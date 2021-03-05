package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("应用列表返回值")
public class FindMembInfoPageVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;

    @ApiModelProperty(value = "应用名称")
    private String commTitle;

    @ApiModelProperty(value = "规格")
    private String specName;

    @ApiModelProperty(value = "有效期")
    private String valid;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "购买日期")
    private OffsetDateTime validStartDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "失效日期")
    private OffsetDateTime validEndDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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
}
