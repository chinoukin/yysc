package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * ele_invo_file 表实体
 * 电子发票文件
 * 2021/01/26 16:30:07
 */
public class EleInvoFile extends DataLongEntity<EleInvoFile> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单发票id
     */
    private Long ordInvoId;

    /**
     * 电子发票url
     */
    private String eleInvoUrl;

    /**
     * 文件类型
     */
    private String fileType;

    private Long ordId;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取订单发票id
     */
    public Long getOrdInvoId() {
        return ordInvoId;
    }

    /**
     * 设置订单发票id
     */
    public void setOrdInvoId(Long ordInvoId) {
        this.ordInvoId = ordInvoId;
    }

    /**
     * 获取电子发票url
     */
    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    /**
     * 设置电子发票url
     */
    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl == null ? null : eleInvoUrl.trim();
    }
}