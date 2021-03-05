package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommMageListVo
 * 2021/01/26 16:30:07
 */
public class CommMageListVo {
    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * pid
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "pid")
    private Long pid;

    /**
     * pids
     */
    @ApiModelProperty(value = "pids")
    private String pids;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String commNum;

    /**
     * 商品分类名称
     */
    @ApiModelProperty(value = "商品分类名称")
    private String commCatgName;

    /**
     * 商品分类名称
     */
    @ApiModelProperty(value = "商品分类父级名称")
    private String commCatgParentName;

    /**
     * 商品状态（有效、无效）
     */
    @ApiModelProperty(value = "商品状态（有效、无效）")
    private String effeInvalState;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标")
    private String catgIconUrl;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词")
    private String keyWord;

    /**
     * 分类描述
     */
    @ApiModelProperty(value = "分类描述")
    private String catgRemarks;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取商品id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取pids
     */
    public String getPids() {
        return pids;
    }

    /**
     * 设置pids
     */
    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    /**
     * 获取商品编号
     */
    public String getCommNum() {
        return commNum;
    }

    /**
     * 设置商品编号
     */
    public void setCommNum(String commNum) {
        this.commNum = commNum == null ? null : commNum.trim();
    }

    /**
     * 获取商品分类名称
     */
    public String getCommCatgName() {
        return commCatgName;
    }

    /**
     * 设置商品分类名称
     */
    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName == null ? null : commCatgName.trim();
    }

    /**
     * 获取商品状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置商品状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取分类图标
     */
    public String getCatgIconUrl() {
        return catgIconUrl;
    }

    /**
     * 设置分类图标
     */
    public void setCatgIconUrl(String catgIconUrl) {
        this.catgIconUrl = catgIconUrl == null ? null : catgIconUrl.trim();
    }

    /**
     * 获取关键词
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 设置关键词
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    /**
     * 获取分类描述
     */
    public String getCatgRemarks() {
        return catgRemarks;
    }

    /**
     * 设置分类描述
     */
    public void setCatgRemarks(String catgRemarks) {
        this.catgRemarks = catgRemarks == null ? null : catgRemarks.trim();
    }

    public String getCommCatgParentName() {
        return commCatgParentName;
    }

    public void setCommCatgParentName(String commCatgParentName) {
        this.commCatgParentName = commCatgParentName;
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}