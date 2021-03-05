package com.wisea.yysc.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改CommAttriSetPo")
public class CommAttriSetPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="商品id")
    private Long commId;

    @ApiModelProperty(value="属性ID")
    private Long attriId;

    @ApiModelProperty(value="是否必填")
    private String ifRequ;

    @ApiModelProperty(value="搜索条件")
    private String ifSearch;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getAttriId() {
        return attriId;
    }

    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    public String getIfRequ() {
        return ifRequ;
    }

    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ;
    }

    public String getIfSearch() {
        return ifSearch;
    }

    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}