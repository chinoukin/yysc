package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("查看详情会员信息返回信息")
public class FindMembInfoVo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value = "手机号")
    private String registTel;

    /**
     * 注册时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;
    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String entpName;
    /**
     * 账户状态
     */
    @ApiModelProperty(value = "账户状态")
    private String acctState;

    /**
     * 所属行业
     */
    @ApiModelProperty(value = "所属行业")
    private String industry;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "注册地址")
    private String address;
    /**
     * 经营规模
     */
    @ApiModelProperty(value = "经营规模")
    private String businessScale;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人姓名")
    private String conter;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "联系邮箱")
    private String email;


    @ApiModelProperty(value = "应用列表")
    private Page<FindMembInfoPageVo> pageList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessScale() {
        return businessScale;
    }

    public void setBusinessScale(String businessScale) {
        this.businessScale = businessScale;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Page<FindMembInfoPageVo> getPageList() {
        return pageList;
    }

    public void setPageList(Page<FindMembInfoPageVo> pageList) {
        this.pageList = pageList;
    }
}
