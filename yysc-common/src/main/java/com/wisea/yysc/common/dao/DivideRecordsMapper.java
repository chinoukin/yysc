package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.DivideRecord;
import com.wisea.yysc.common.po.DivideRecordListPo;
import com.wisea.yysc.common.po.DivideRecordPagePo;
import com.wisea.yysc.common.vo.DivideRecordListVo;
import java.util.List;

/**
 * divide_record 表DAO
 * 分账记录
 * 2021/01/26 16:30:07
 */
public interface DivideRecordsMapper extends CrudDao<DivideRecord> {
    List<DivideRecordListVo> findPage(DivideRecordPagePo divideRecordPagePo);

    List<DivideRecordListVo> findList(DivideRecordListPo divideRecordListPo);
}