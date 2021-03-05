package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.PayRecord;
import com.wisea.yysc.common.po.PayRecordListPo;
import com.wisea.yysc.common.po.PayRecordPagePo;
import com.wisea.yysc.common.vo.PayRecordListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * pay_record 表DAO
 * 支付记录
 * 2021/01/26 16:30:07
 */
@Repository
public interface PayRecordsMapper extends CrudDao<PayRecord> {
    List<PayRecordListVo> findPage(PayRecordPagePo payRecordPagePo);

    List<PayRecordListVo> findList(PayRecordListPo payRecordListPo);

   /* PayRecord findByOrdId(PayRecordListPo payRecordListPo);

    PayRecord findByOutTradeNo(@Param("outTradeNo") String outTradeNo);

    // 带乐观锁的更新
    int updateByPrimaryKeyWithOptimisticLock(PayRecord payRecord);*/
}