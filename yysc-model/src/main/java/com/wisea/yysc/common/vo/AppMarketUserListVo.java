package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 *  应用市场用户列表
 *
 */
@ApiModel("获取应用市场用户列表信息VO")
public class AppMarketUserListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "序号")
    @ExcelField(title = "序号", sort = 10)
    private String rownum;
    @ApiModelProperty(value = "手机号")
    @ExcelField(title = "手机号", sort = 20)
    private String registTel;
    @ApiModelProperty(value = "应用数量")
    @ExcelField(title = "应用数量", sort = 30)
    private String appSum;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ExcelField(title = "注册时间", sort = 40)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;
    @ApiModelProperty(value = "账户状态")
    @ExcelField(title = "账户状态", sort = 50)
    private String acctState;
    @ApiModelProperty(value = "姓名")
    private String contName;
    @ApiModelProperty(value = "企业名称")
    private String entpName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRownum() {
        return rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getAppSum() {
        return appSum;
    }

    public void setAppSum(String appSum) {
        this.appSum = appSum;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
}
