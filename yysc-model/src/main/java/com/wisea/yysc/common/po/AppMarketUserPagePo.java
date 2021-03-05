package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.yysc.common.vo.AppMarketUserListVo;
import com.wisea.yysc.common.vo.AppMarketUserListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 应用市场用户
 *  wzx
 */
@ApiModel("应用市场用户列表查询参数PO")
public class AppMarketUserPagePo extends PagePo<AppMarketUserListVo> {

    @ApiModelProperty(value = "手机号")
    private String registTel;

    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    @ApiModelProperty(value = "复选框选择导出是传入id")
    private List<Long> list;

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}
