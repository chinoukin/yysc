package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.CommAttriSet;
import com.wisea.yysc.common.po.product.CommAttriSetPageListPo;
import com.wisea.yysc.common.vo.product.CommAttriSetInfoVo;
import com.wisea.yysc.common.vo.product.CommAttriSetPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_attri_set 表DAO
 * 商品属性设置
 * 2021/01/26 16:30:07
 */

@Mapper
@Repository
public interface CommAttriSetMapper extends CrudDao<CommAttriSet> {
    /**
     * @author wbf-code-generator
     * @date 2021/01/28 15:49:59
     * @Description 分页查询CommAttriSet
     */
    List<CommAttriSetPageListVo> findPageList(CommAttriSetPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 15:49:59
     * @Description 查询详细信息CommAttriSet
     */
    CommAttriSetInfoVo findInfo(LongIdPo po);

    /**
     * 属性删除时删除相关属性设置
     * @param id
     */
    void updateByAttriId(Long id);
}