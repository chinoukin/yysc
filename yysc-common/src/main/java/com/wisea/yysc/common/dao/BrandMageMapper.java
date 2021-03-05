package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.BrandMage;
import com.wisea.yysc.common.po.BrandMageListPo;
import com.wisea.yysc.common.po.BrandMagePagePo;
import com.wisea.yysc.common.vo.BrandMageListVo;
import java.util.List;

/**
 * brand_mage 表DAO
 * 品牌管理
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface BrandMageMapper extends CrudDao<BrandMage> {
    List<BrandMageListVo> findPage(BrandMagePagePo brandMagePagePo);

    List<BrandMageListVo> findList(BrandMageListPo brandMageListPo);
}