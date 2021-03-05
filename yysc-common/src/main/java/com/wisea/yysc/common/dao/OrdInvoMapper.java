package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.OrdInvo;
import com.wisea.yysc.common.po.OrdInvoListPo;
import com.wisea.yysc.common.po.OrdInvoPagePo;
import com.wisea.yysc.common.po.trade.OrderInvoPageListPo;
import com.wisea.yysc.common.vo.OrdInvoGetVo;
import com.wisea.yysc.common.vo.OrdInvoListVo;
import com.wisea.yysc.common.vo.trade.OrderInvoPageListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ord_invo 表DAO
 * 订单发票
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface OrdInvoMapper extends CrudDao<OrdInvo> {
    List<OrdInvoListVo> findPage(OrdInvoPagePo ordInvoPagePo);

    List<OrdInvoListVo> findList(OrdInvoListPo ordInvoListPo);

    /**
     * 查询发票列表
     * @param orderfoInvoPageListPo
     * @return
     */
    List<OrderInvoPageListVo> findPageList(OrderInvoPageListPo orderfoInvoPageListPo);

    /**
     * 后台查询发票详情
     * @param po
     * @return
     */
    OrdInvoGetVo findInfo(LongIdPo po);
}