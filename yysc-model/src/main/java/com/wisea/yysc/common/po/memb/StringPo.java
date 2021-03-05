package com.wisea.yysc.common.po.memb;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("只传String类型参数的PO")
public class StringPo {
    @ApiModelProperty(
            value = "String类型的参数 (必填)",
            required = true
    )
    @Check(
            test = {"required"}
    )
    private String keyStr;

    public StringPo() {
    }

    public String getKeyStr() {
        return this.keyStr;
    }

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }
}
