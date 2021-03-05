package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.CommAttri;
import com.wisea.yysc.common.po.CommAttriListPo;
import com.wisea.yysc.common.po.CommAttriPagePo;
import com.wisea.yysc.common.vo.CommAttriListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_attri 表DAO
 * 商品属性值
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Mapper
@Repository
public interface CommAttriMapper extends CrudDao<CommAttri> {
    List<CommAttriListVo> findPage(CommAttriPagePo commAttriPagePo);

    List<CommAttriListVo> findList(CommAttriListPo commAttriListPo);

    void deleteByCommPubId(Long id);

}