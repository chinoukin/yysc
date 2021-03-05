package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.YspayEntpRecord;
import com.wisea.yysc.common.po.YspayEntpRecordListPo;
import com.wisea.yysc.common.po.YspayEntpRecordPagePo;
import com.wisea.yysc.common.vo.YspayEntpRecordListVo;
import java.util.List;

/**
 * yspay_entp_record 表DAO
 * 子商户入驻记录
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface YspayEntpRecordMapper extends CrudDao<YspayEntpRecord> {
    List<YspayEntpRecordListVo> findPage(YspayEntpRecordPagePo yspayEntpRecordPagePo);

    List<YspayEntpRecordListVo> findList(YspayEntpRecordListPo yspayEntpRecordListPo);
}