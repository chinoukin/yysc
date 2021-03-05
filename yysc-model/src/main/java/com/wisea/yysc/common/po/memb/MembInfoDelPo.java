package com.wisea.yysc.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("删除用户参数的PO")
public class MembInfoDelPo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
