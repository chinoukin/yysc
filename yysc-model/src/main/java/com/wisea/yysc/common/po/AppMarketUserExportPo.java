package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

public class AppMarketUserExportPo {
    @ApiModelProperty(value = "手机号")
    private String registTel;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }
}
