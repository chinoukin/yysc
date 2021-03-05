package com.wisea.yysc.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * DeadLineMageInsertPo
 * 2021/01/26 16:30:07
 */
public class DeadLineMageInsertPo {
    /**
     * 期限类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "期限类型")
    private String deadLineType;

    /**
     * 时间限制
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "时间限制")
    private Integer limitDays;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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
}