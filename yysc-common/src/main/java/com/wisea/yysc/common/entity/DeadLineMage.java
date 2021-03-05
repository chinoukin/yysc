package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * dead_line_mage 表实体
 * 期限管理
 * 2021/01/26 16:30:07
 */
@ApiModel("订单期限管理")
public class DeadLineMage extends DataLongEntity<DeadLineMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 期限类型
     */
    private String deadLineType;

    /**
     * 时间限制
     */
    @ApiModelProperty(value = "对应期限")
    private Integer limitDays;

    /**
     * 获取期限类型
     */
    public String getDeadLineType() {
        return deadLineType;
    }

    /**
     * 设置期限类型
     */
    public void setDeadLineType(String deadLineType) {
        this.deadLineType = deadLineType == null ? null : deadLineType.trim();
    }

    /**
     * 获取时间限制
     */
    public Integer getLimitDays() {
        return limitDays;
    }

    /**
     * 设置时间限制
     */
    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }
}