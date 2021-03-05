package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * DeadLineMageGetVo
 * 2021/01/26 16:30:07
 */
public class DeadLineMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 期限类型
     */
    @ApiModelProperty(value = "期限类型")
    private String deadLineType;

    /**
     * 时间限制
     */
    @ApiModelProperty(value = "时间限制")
    private Integer limitDays;

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
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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