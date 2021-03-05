package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.ApplicationVisitMage;
import com.wisea.yysc.common.po.product.ApplicationVisitMagePageListPo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMageInfoVo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * application_visit_mage 表DAO
 * 应用访问配置
 * 2021/01/26 16:30:07
 */
@Mapper
@Repository
public interface ApplicationVisitMageMapper extends CrudDao<ApplicationVisitMage> {
    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 分页查询ApplicationVisitMage
     */
    List<ApplicationVisitMagePageListVo> findPageList(ApplicationVisitMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 查询详细信息ApplicationVisitMage
     */
    ApplicationVisitMageInfoVo findInfo(LongIdPo po);

    /**
     * 查看重复编码
     * @param unitNum
     * @return
     */
    ApplicationVisitMageInfoVo findUnitNum(String unitNum);
}