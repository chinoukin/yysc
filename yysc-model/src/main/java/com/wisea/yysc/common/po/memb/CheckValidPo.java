package com.wisea.yysc.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

public class CheckValidPo {

    @JsonSerialize(using = IdSerializer.class)
    private Long userId; //用户ID

    private String loginType; //登录标示

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
