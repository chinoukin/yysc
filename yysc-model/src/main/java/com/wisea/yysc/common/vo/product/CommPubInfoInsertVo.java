package com.wisea.yysc.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CommPubInfoInsertVo")
public class CommPubInfoInsertVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String commTitle;

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
}
