package com.wisea.yysc.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className YspayBanks
 * @date 2020/6/1 9:21
 * @Description 银盛支付银行列表
 */
@ApiModel("银盛银行Entity")
public class YspayBanks {
    @ApiModelProperty("银行行别名称  注：查询银行全称列表时，该字段不能为空")
    private String bankName;
    @ApiModelProperty("银行全称  注：查询银行行别名称列表时，该字段不能传值")
    private String subBranchName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubBranchName() {
        return subBranchName;
    }

    public void setSubBranchName(String subBranchName) {
        this.subBranchName = subBranchName;
    }
}
