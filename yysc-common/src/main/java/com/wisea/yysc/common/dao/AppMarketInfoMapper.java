package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.AppMarketInfo;
import com.wisea.yysc.common.po.AppMarketInfoListPo;
import com.wisea.yysc.common.po.AppMarketInfoPagePo;
import com.wisea.yysc.common.vo.AppMarketInfoListVo;
import com.wisea.yysc.common.vo.AppMarketInfoVo;

import java.util.List;

/**
 * app_market_info 表DAO
 * 应用市场信息
 * 2021/01/26 16:30:07
 */
public interface AppMarketInfoMapper extends CrudDao<AppMarketInfo> {
    /**
     * 查询应用市场信息设置
     * @return
     */
    AppMarketInfoVo findAppMarketInfo();
}