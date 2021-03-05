package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommAttriMageGetPo
 * 2021/01/26 16:30:07
 */
public class CommAttriMageGetPo {
    /**
     * 属性id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="属性id")
    @Check(test = "required")
    private Long id;

    /**
     * 获取属性id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置属性id
     */
    public void setId(Long id) {
        this.id = id;
    }
}