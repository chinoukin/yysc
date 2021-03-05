package com.wisea.yysc.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CommAttriSet详细信息Vo")
public class CommAttriSetInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品id")
    private Long commId;

    @ApiModelProperty(value="属性ID")
    private Long attriId;

    @ApiModelProperty(value="属性名称")
    private String commAttriName;

    @ApiModelProperty(value="属性字段")
    private String commAttriColumn;

    @ApiModelProperty(value = "商品分类名称")
    private String commCatgName;

    @ApiModelProperty(value="是否必填")
    private String ifRequ;

    @ApiModelProperty(value="搜索条件")
    private String ifSearch;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    @ApiModelProperty(value = "商品分类ID")
    private String commodity;


    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }
}