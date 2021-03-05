package com.wisea.yysc.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("返回添加应用所需数据WebPageListVo")
public class WebPageListVo {
    @ApiModelProperty(value="类型")
    private String name;
    @ApiModelProperty(value="类型数据")
    private List<CommPubInfoPageListVo> commPubInfoPageListVoList;

    public List<CommPubInfoPageListVo> getCommPubInfoPageListVoList() {
        return commPubInfoPageListVoList;
    }

    public void setCommPubInfoPageListVoList(List<CommPubInfoPageListVo> commPubInfoPageListVoList) {
        this.commPubInfoPageListVoList = commPubInfoPageListVoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
