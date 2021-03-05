package com.wisea.yysc.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * CommAttriBatDeletePo
 * 2021/01/26 16:30:07
 */
public class CommAttriBatDeletePo {
    /**
     * 批量删除列表
     */
    @Check(test = "required")
    @ApiModelProperty(value = "批量删除列表")
    private List<Long> delList;

    /**
     * 获取批量删除列表
     */
    public List<Long> getDelList() {
        return delList;
    }

    /**
     * 设置批量删除列表
     */
    public void setDelList(List<Long> delList) {
        this.delList = delList;
    }
}