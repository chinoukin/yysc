package com.wisea.yysc.common.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MembInfoListPo
 * 2021/01/26 16:30:07
 */
public class MembInfoListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * logo_url
     */
    @ApiModelProperty(value = "logo_url")
    private String logoUrl;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String petName;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String contName;

    /**
     * 登陆用户名
     */
    @ApiModelProperty(value = "登陆用户名")
    private String loginName;

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
     * 注册地省
     */
    @ApiModelProperty(value = "注册地省")
    private String areaProv;

    /**
     * 注册地市
     */
    @ApiModelProperty(value = "注册地市")
    private String areaCity;

    /**
     * 注册地区县
     */
    @ApiModelProperty(value = "注册地区县")
    private String areaCou;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String conter;

    /**
     * 联系人手机号
     */
    @ApiModelProperty(value = "联系人手机号")
    private String contTel;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 注册时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    /**
     * 经营规模
     */
    @ApiModelProperty(value = "经营规模")
    private String businessScale;

    /**
     * 会员类型
     */
    @ApiModelProperty(value = "会员类型")
    private String membType;

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
     * 获取logo_url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置logo_url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * 获取注册手机号
     */
    public String getRegistTel() {
        return registTel;
    }

    /**
     * 设置注册手机号
     */
    public void setRegistTel(String registTel) {
        this.registTel = registTel == null ? null : registTel.trim();
    }

    /**
     * 获取昵称
     */
    public String getPetName() {
        return petName;
    }

    /**
     * 设置昵称
     */
    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    /**
     * 获取姓名
     */
    public String getContName() {
        return contName;
    }

    /**
     * 设置姓名
     */
    public void setContName(String contName) {
        this.contName = contName == null ? null : contName.trim();
    }

    /**
     * 获取登陆用户名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登陆用户名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取账户状态
     */
    public String getAcctState() {
        return acctState;
    }

    /**
     * 设置账户状态
     */
    public void setAcctState(String acctState) {
        this.acctState = acctState == null ? null : acctState.trim();
    }

    /**
     * 获取所属行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置所属行业
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * 获取注册地省
     */
    public String getAreaProv() {
        return areaProv;
    }

    /**
     * 设置注册地省
     */
    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv == null ? null : areaProv.trim();
    }

    /**
     * 获取注册地市
     */
    public String getAreaCity() {
        return areaCity;
    }

    /**
     * 设置注册地市
     */
    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity == null ? null : areaCity.trim();
    }

    /**
     * 获取注册地区县
     */
    public String getAreaCou() {
        return areaCou;
    }

    /**
     * 设置注册地区县
     */
    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou == null ? null : areaCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系人手机号
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系人手机号
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }

    /**
     * 获取邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取注册时间
     */
    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    /**
     * 设置注册时间
     */
    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    /**
     * 获取经营规模
     */
    public String getBusinessScale() {
        return businessScale;
    }

    /**
     * 设置经营规模
     */
    public void setBusinessScale(String businessScale) {
        this.businessScale = businessScale == null ? null : businessScale.trim();
    }

    /**
     * 获取会员类型
     */
    public String getMembType() {
        return membType;
    }

    /**
     * 设置会员类型
     */
    public void setMembType(String membType) {
        this.membType = membType == null ? null : membType.trim();
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