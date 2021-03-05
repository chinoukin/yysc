package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

public class AppMarketUserExportListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "手机号")
    private String registTel;
    @ApiModelProperty(value = "应用数量")
    private String appSum;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;
    @ApiModelProperty(value = "账户状态")
    private String acctState;
    @ApiModelProperty(value = "姓名")
    private String contName;
    @ApiModelProperty(value = "企业名称")
    private String entpName;

}
