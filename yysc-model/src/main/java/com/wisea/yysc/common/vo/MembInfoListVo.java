package com.wisea.yysc.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MembInfoListVo
 * 2021/01/26 16:30:07
 */
public class MembInfoListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 登陆用户名
     */
    @ApiModelProperty(value = "成员账号")
    private String loginName;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String contName;

    /**
     * 联系人手机号
     */
    @ApiModelProperty(value = "联系电话")
    private String contTel;

    /**
     * 账户状态
     */
    @ApiModelProperty(value = "是否启用")
    private String acctState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }
}