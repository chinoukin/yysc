package com.wisea.yysc.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

public class CheckValidVo {

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime validEndDate;

    private String loginType;

    public OffsetDateTime getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(OffsetDateTime validEndDate) {
        this.validEndDate = validEndDate;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
