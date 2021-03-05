package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.yysc.common.entity.UserAgreementMage;

/**
 * user_agreement_mage 表实体
 * 用户协议
 * 2021/02/04 10:50:41
 */
public class UserAgreementMage extends DataLongEntity<UserAgreementMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户协议
     */
    private String userAgreement;

    /**
     * 获取用户协议
     */
    public String getUserAgreement() {
        return userAgreement;
    }

    /**
     * 设置用户协议
     */
    public void setUserAgreement(String userAgreement) {
        this.userAgreement = userAgreement == null ? null : userAgreement.trim();
    }
}