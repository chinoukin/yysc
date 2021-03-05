package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * comm_picture 表实体
 * 商品图片信息
 * 2021/01/26 16:30:07
 */
public class CommPicture extends DataLongEntity<CommPicture> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图片url
     */
    private String url;

    /**
     * 图片类型（主图、细节图）
     */
    private String commPictureType;

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取图片类型（主图、细节图）
     */
    public String getCommPictureType() {
        return commPictureType;
    }

    /**
     * 设置图片类型（主图、细节图）
     */
    public void setCommPictureType(String commPictureType) {
        this.commPictureType = commPictureType == null ? null : commPictureType.trim();
    }
}