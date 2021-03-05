package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.OrdOpreateInfo;
import com.wisea.yysc.common.po.OrdOpreateInfoListPo;
import com.wisea.yysc.common.po.OrdOpreateInfoPagePo;
import com.wisea.yysc.common.vo.OrdOpreateInfoListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ord_opreate_info 表DAO
 * 订单操作信息
 * 2021/01/26 16:30:07
 */
@Repository
public interface OrdOpreateInfoMapper extends CrudDao<OrdOpreateInfo> {
    List<OrdOpreateInfoListVo> findPage(OrdOpreateInfoPagePo ordOpreateInfoPagePo);

    List<OrdOpreateInfoListVo> findList(OrdOpreateInfoListPo ordOpreateInfoListPo);
}