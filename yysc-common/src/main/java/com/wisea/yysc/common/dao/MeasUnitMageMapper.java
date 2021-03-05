package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.MeasUnitMage;
import com.wisea.yysc.common.po.product.MeasUnitMagePageListPo;
import com.wisea.yysc.common.vo.product.MeasUnitMageInfoVo;
import com.wisea.yysc.common.vo.product.MeasUnitMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * meas_unit_mage 表DAO
 * 计量单位管理
 * 2021/01/26 16:30:07
 */
@Mapper
@Repository
public interface MeasUnitMageMapper extends CrudDao<MeasUnitMage> {
    /**
     * @author wbf-code-generator
     * @date 2021/01/29 10:42:38
     * @Description 分页查询MeasUnitMage
     */
    List<MeasUnitMagePageListVo> findPageList(MeasUnitMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 10:42:38
     * @Description 查询详细信息MeasUnitMage
     */
    MeasUnitMageInfoVo findInfo(LongIdPo po);
}