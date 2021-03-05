package com.wisea.yysc.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("验证手机号是否存在的PO")
public class MembCheckMobilePo {
    @ApiModelProperty("手机号")
    @Check(
            test = {"required"}
    )
    private String mobile;
    @ApiModelProperty("会员ID(修改手机号的时候传入)")
    @JsonSerialize(
            using = IdSerializer.class
    )
    private Long membId;

    public MembCheckMobilePo() {
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getMembId() {
        return this.membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
