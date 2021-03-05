package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.CommMage;
import com.wisea.yysc.common.po.CommMageListPo;
import com.wisea.yysc.common.po.CommMagePagePo;
import com.wisea.yysc.common.po.product.CommMageTreePo;
import com.wisea.yysc.common.po.product.CommPubInfoPo;
import com.wisea.yysc.common.vo.CommAttriMageListVo;
import com.wisea.yysc.common.vo.CommMageListVo;
import com.wisea.yysc.common.vo.product.CommMageTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_mage 表DAO
 * 商品管理
 * 2021/01/26 16:30:07
 */

@Mapper
@Repository
public interface CommMageMapper extends CrudDao<CommMage> {
    /**
     * 分页查询
     */
    List<CommMageListVo> findPage(CommMagePagePo commMagePagePo);
    /**
     * 列表查询
     */
    List<CommMageTreeVo> findList(CommMageTreePo commMageTreePo);

    /**
     * 查询商品分类关联的商品
     * @param id
     * @return
     */
    Integer selectCommPubCount(Long id);

    /***
     * 查询分类下有没有子类
     * @param longIdPo
     * @return
     */
    List<CommMage> findSalesClassReleaseByCommId(LongIdPo longIdPo);

    /***
     * 通过id找父级信息
     * @param po
     * @return
     */
    CommMage findPid(Long po);
    /***
     * 通过分类id查找商品属性
     * @param
     * @return
     */
    List<CommAttriMageListVo> findAttrByCommId(Long id);

    CommMageListVo selectByPrimary(Long id);
}