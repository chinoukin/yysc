package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.FindMembInfoPageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查看详情会员信息参数")
public class FindMembInfoPo extends PagePo<FindMembInfoPageVo> {

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
