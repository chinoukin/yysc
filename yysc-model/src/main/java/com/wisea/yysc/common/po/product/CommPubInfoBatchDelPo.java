package com.wisea.yysc.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("批量上下架CommPubInfoBatchDelPo")
public class CommPubInfoBatchDelPo {
    @Check(test = "required", requiredMsg = "状态不能为空")
    @ApiModelProperty(value = "状态")
    private String state;
    @Check(test = "required", requiredMsg = "ids不能为空")
    @ApiModelProperty(value="需要上下架的id")
    private List<String> ids;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
