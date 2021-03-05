package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.UserAgreementMage;
import com.wisea.yysc.common.po.UserAgreementMageListPo;
import com.wisea.yysc.common.po.UserAgreementMagePagePo;
import com.wisea.yysc.common.vo.UserAgreementMageGetVo;
import com.wisea.yysc.common.vo.UserAgreementMageListVo;

import java.util.List;


/**
 * user_agreement_mage 表DAO
 * 用户协议
 * 2021/02/04 10:50:41
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface UserAgreementMageMapper extends CrudDao<UserAgreementMage> {
    List<UserAgreementMageListVo> findPage(UserAgreementMagePagePo userAgreementMagePagePo);

    List<UserAgreementMageListVo> findList(UserAgreementMageListPo userAgreementMageListPo);

    /**
     * 查询
     */
    UserAgreementMageGetVo findInfo();
}