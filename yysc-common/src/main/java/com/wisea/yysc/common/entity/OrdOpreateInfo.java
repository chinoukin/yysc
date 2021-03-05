package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * ord_opreate_info 表实体
 * 订单操作信息
 * 2021/01/26 16:30:07
 */
public class OrdOpreateInfo extends DataLongEntity<OrdOpreateInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Long ordId;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime opreatDate;

    /**
     * 操作内容
     */
    private String opreatContent;

    /**
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作者
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取操作时间
     */
    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    /**
     * 设置操作时间
     */
    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    /**
     * 获取操作内容
     */
    public String getOpreatContent() {
        return opreatContent;
    }

    /**
     * 设置操作内容
     */
    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent == null ? null : opreatContent.trim();
    }
}