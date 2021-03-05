package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.OrdCancelReasonMage;
import com.wisea.yysc.common.po.OrdCancelReasonMageListPo;
import com.wisea.yysc.common.po.OrdCancelReasonMagePagePo;
import com.wisea.yysc.common.po.trade.OrdCancelReasonMagePageListPo;
import com.wisea.yysc.common.vo.OrdCancelReasonMageListVo;
import com.wisea.yysc.common.vo.trade.OrdCancelReasonMageInfoVo;
import com.wisea.yysc.common.vo.trade.OrdCancelReasonMagePageListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ord_cancel_reason_mage 表DAO
 * 订单取消原因管理
 * 2021/01/26 16:30:07
 */
@Repository
public interface OrdCancelReasonMageMapper extends CrudDao<OrdCancelReasonMage> {
    List<OrdCancelReasonMageListVo> findPage(OrdCancelReasonMagePagePo ordCancelReasonMagePagePo);

    List<OrdCancelReasonMageListVo> findList(OrdCancelReasonMageListPo ordCancelReasonMageListPo);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询OrdCancelReasonMage
     */
    List<OrdCancelReasonMagePageListVo> findPageList(OrdCancelReasonMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息OrdCancelReasonMage
     */
    OrdCancelReasonMageInfoVo findInfo(LongIdPo po);

    /**
     * 查询订单取消原因
     * @return
     */
    List<OrdCancelReasonMageListVo> findAllReason();
}