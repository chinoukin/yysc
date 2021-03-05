package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.CollAcctMage;
import com.wisea.yysc.common.po.CollAcctMageListPo;
import com.wisea.yysc.common.po.CollAcctMagePagePo;
import com.wisea.yysc.common.vo.CollAcctMageGetVo;
import com.wisea.yysc.common.vo.CollAcctMageListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * coll_acct_mage 表DAO
 * 收款账号设置
 * 2021/02/04 10:50:41
 */
@Repository
public interface CollAcctMageMapper extends CrudDao<CollAcctMage> {
    List<CollAcctMageListVo> findPage(CollAcctMagePagePo collAcctMagePagePo);

    List<CollAcctMageListVo> findList(CollAcctMageListPo collAcctMageListPo);

    /**
     * 查询
     * @return
     */
    CollAcctMageGetVo findInfo();
}