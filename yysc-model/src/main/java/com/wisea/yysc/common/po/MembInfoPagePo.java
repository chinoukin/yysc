package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.MembInfoListVo;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MembInfoPagePo
 * 2021/01/26 16:30:07
 */
public class MembInfoPagePo extends PagePo<MembInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 查询条件
     */
    @ApiModelProperty(value = "查询条件")
    private String val;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",hidden = true)
    private Long createBy;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}