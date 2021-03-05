package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.DivideEvent;
import com.wisea.yysc.common.po.DivideEventListPo;
import com.wisea.yysc.common.po.DivideEventPagePo;
import com.wisea.yysc.common.vo.DivideEventListVo;
import java.util.List;

/**
 * divide_event 表DAO
 * 分账事件
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface DivideEventMapper extends CrudDao<DivideEvent> {
    List<DivideEventListVo> findPage(DivideEventPagePo divideEventPagePo);

    List<DivideEventListVo> findList(DivideEventListPo divideEventListPo);
}