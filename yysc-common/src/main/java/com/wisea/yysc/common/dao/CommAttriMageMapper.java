package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.CommAttriMage;
import com.wisea.yysc.common.po.product.CommAttriMagePageListPo;
import com.wisea.yysc.common.po.product.CommTree;
import com.wisea.yysc.common.vo.product.CommAttriMageInfoVo;
import com.wisea.yysc.common.vo.product.CommAttriMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_attri_mage 表DAO
 * 商品属性
 * 2021/01/26 16:30:07
 */
@Mapper
@Repository
public interface CommAttriMageMapper extends CrudDao<CommAttriMage> {
    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 分页查询CommAttriMage
     */
    List<CommAttriMagePageListVo> findPageList(CommAttriMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 查询详细信息CommAttriMage
     */
    CommAttriMageInfoVo findInfo(LongIdPo po);

    List<CommTree> beforeInsertGetCatgList();

}