package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * comm_mage 表实体
 * 商品管理
 * 2021/01/26 16:30:07
 */
public class CommMage extends DataLongEntity<CommMage> {
    private static final long serialVersionUID = 1L;

    /**
     * pid
     */
    private Long pid;

    /**
     * pids
     */
    private String pids;

    /**
     * 商品编号
     */
    private String commNum;

    /**
     * 商品分类名称
     */
    private String commCatgName;

    /**
     * 商品状态（有效、无效）
     */
    private String effeInvalState;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 分类图标
     */
    private String catgIconUrl;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 分类描述
     */
    private String catgRemarks;

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
}