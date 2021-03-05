package com.wisea.yysc.common.po.memb;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("修改成员基本信息")
public class UpdMembPo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 登陆用户名
     */
    @ApiModelProperty(value = "成员账号")
    @Check(test = "required")
    private String loginName;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @Check(test = "required")
    private String contName;
    @ApiModelProperty(value="登录密码")
    private String password;
    @ApiModelProperty(value="确认密码")
    private String conPwd;
    /**
     * 联系人手机号
     */
    @Check(test = "required")
    @ApiModelProperty(value = "联系人手机号")
    private String contTel;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;
    /**
     * 菜单.id字符串数组(使用逗号分隔),如果为空不处理
     */
    @ApiModelProperty(value = "菜单.id字符串数组(使用逗号分隔),如果为空不处理")
    private String menuIds;
    /**
     * 是否清除菜单标识(true:清空false:不操作 默认是false)
     */
    @ApiModelProperty(value = "是否清除菜单标识(true:清空false:不操作 默认是false)")
    private boolean clearMenuFlag = false;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConPwd() {
        return conPwd;
    }

    public void setConPwd(String conPwd) {
        this.conPwd = conPwd;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isClearMenuFlag() {
        return clearMenuFlag;
    }

    public void setClearMenuFlag(boolean clearMenuFlag) {
        this.clearMenuFlag = clearMenuFlag;
    }
}
