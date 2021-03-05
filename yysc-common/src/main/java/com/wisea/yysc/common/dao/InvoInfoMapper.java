package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.InvoInfo;
import com.wisea.yysc.common.po.InvoInfoListPo;
import com.wisea.yysc.common.po.InvoInfoPagePo;
import com.wisea.yysc.common.po.trade.InvoInfoPageListPo;
import com.wisea.yysc.common.vo.InvoInfoListVo;
import com.wisea.yysc.common.vo.trade.InvoInfoInfoVo;
import com.wisea.yysc.common.vo.trade.InvoInfoPageListVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * invo_info 表DAO
 * 发票信息
 * 2021/01/26 16:30:07
 */
@Repository
public interface InvoInfoMapper extends CrudDao<InvoInfo> {
    List<InvoInfoListVo> findPage(InvoInfoPagePo invoInfoPagePo);

    List<InvoInfoListVo> findList(InvoInfoListPo invoInfoListPo);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询InvoInfo
     */
    List<InvoInfoPageListVo> findPageList(InvoInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息InvoInfo
     */
    InvoInfoInfoVo findInfo(LongIdPo po);

    /**
     * 根据会员ID查询默认发票
     * @param membId
     * @return
     */
    InvoInfoInfoVo selDefaultInvoByMembId(Long membId);
}