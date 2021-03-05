package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.LevelSpecQuote;
import com.wisea.yysc.common.po.LevelSpecQuoteListPo;
import com.wisea.yysc.common.po.LevelSpecQuotePagePo;
import com.wisea.yysc.common.vo.LevelSpecQuoteListVo;
import com.wisea.yysc.common.vo.product.LevelSpecQuoteInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * level_spec_quote 表DAO
 * 售卖规格
 * 2021/01/26 16:30:07
 */
@Mapper
@Repository
public interface LevelSpecQuoteMapper extends CrudDao<LevelSpecQuote> {
    List<LevelSpecQuoteListVo> findPage(LevelSpecQuotePagePo levelSpecQuotePagePo);

    List<LevelSpecQuoteListVo> findList(LevelSpecQuoteListPo levelSpecQuoteListPo);


    void deleteByCommPubId(Long id);



    List<LevelSpecQuoteInfoVo> beforeDelSelectMeas(Long id);
}