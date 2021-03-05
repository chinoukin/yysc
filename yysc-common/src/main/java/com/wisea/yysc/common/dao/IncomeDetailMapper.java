package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.IncomeDetail;
import com.wisea.yysc.common.po.IncomeDetailListPo;
import com.wisea.yysc.common.po.IncomeDetailPagePo;
import com.wisea.yysc.common.vo.IncomeDetailListVo;
import java.util.List;

/**
 * income_detail 表DAO
 * 收入明细
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface IncomeDetailMapper extends CrudDao<IncomeDetail> {
    List<IncomeDetailListVo> findPage(IncomeDetailPagePo incomeDetailPagePo);

    List<IncomeDetailListVo> findList(IncomeDetailListPo incomeDetailListPo);
}