package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * memb_info 表实体
 * 会员信息
 * 2021/01/26 16:30:07
 */
public class MembInfo extends DataLongEntity<MembInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * logo_url
     */
    private String logoUrl;

    /**
     * 注册手机号
     */
    private String registTel;

    /**
     * 昵称
     */
    private String petName;

    /**
     * 姓名
     */
    private String contName;

    /**
     * 登陆用户名
     */
    private String loginName;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 账户状态
     */
    private String acctState;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 注册地省
     */
    private String areaProv;

    /**
     * 注册地市
     */
    private String areaCity;

    /**
     * 注册地区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系人手机号
     */
    private String contTel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private OffsetDateTime registDate;

    /**
     * 经营规模
     */
    private String businessScale;

    /**
     * 会员类型
     */
    private String membType;

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
}