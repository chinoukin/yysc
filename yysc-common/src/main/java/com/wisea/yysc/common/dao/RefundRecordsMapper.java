package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.RefundRecord;
import com.wisea.yysc.common.po.RefundRecordListPo;
import com.wisea.yysc.common.po.RefundRecordPagePo;
import com.wisea.yysc.common.vo.RefundRecordListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * refund_record 表DAO
 * 退款记录
 * 2021/01/26 16:30:07
 */
@Repository
public interface RefundRecordsMapper extends CrudDao<RefundRecord> {
    List<RefundRecordListVo> findPage(RefundRecordPagePo refundRecordPagePo);

    List<RefundRecordListVo> findList(RefundRecordListPo refundRecordListPo);
}