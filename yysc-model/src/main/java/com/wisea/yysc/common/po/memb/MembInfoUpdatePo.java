package com.wisea.yysc.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MembInfoUpdatePo
 * 2021/01/26 16:30:07
 */
public class MembInfoUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
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
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String entpName;

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
     * 所属行业
     */
    @ApiModelProperty(value = "所属行业")
    private String industry;

    /**
     * 经营规模
     */
    @ApiModelProperty(value = "经营规模")
    private String businessScale;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}