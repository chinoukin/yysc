package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.DeadLineMage;
import com.wisea.yysc.common.po.DeadLineMageListPo;
import com.wisea.yysc.common.po.DeadLineMagePagePo;
import com.wisea.yysc.common.vo.DeadLineMageListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dead_line_mage 表DAO
 * 期限管理
 * 2021/01/26 16:30:07
 */
@Repository
public interface DeadLineMageMapper extends CrudDao<DeadLineMage> {

    /**
     * 查询订单期限
     * @return
     */
    DeadLineMage getDeadLineMage();

    List<DeadLineMageListVo> findPage(DeadLineMagePagePo deadLineMagePagePo);

    List<DeadLineMageListVo> findList(DeadLineMageListPo deadLineMageListPo);
}