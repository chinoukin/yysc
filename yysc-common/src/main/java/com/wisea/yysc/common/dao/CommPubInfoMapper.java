package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.entity.CommPubInfo;
import com.wisea.yysc.common.po.product.CommPubInfoBatchDelPo;
import com.wisea.yysc.common.po.product.CommPubInfoPageListPo;
import com.wisea.yysc.common.vo.ApplicationVisitMageListVo;
import com.wisea.yysc.common.vo.product.CommPubInfoInfoVo;
import com.wisea.yysc.common.vo.product.CommPubInfoPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_pub_info 表DAO
 * 商品发布信息
 * 2021/01/26 16:30:07
 */

@Mapper
@Repository
public interface CommPubInfoMapper extends CrudDao<CommPubInfo> {
    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 分页查询CommPubInfo
     */
    List<CommPubInfoPageListVo> findPageList(CommPubInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 查询详细信息CommPubInfo
     */
    CommPubInfoInfoVo findInfo(LongIdPo po);
    //上下架操作
    void batchDel(@Param("ids") List<String> ids,@Param("state") String state);
    //前三商品
    List<CommPubInfoPageListVo> findTopThree(Long commId);
    //查找应用访问配置
    List<ApplicationVisitMageListVo> findApplicationVisit();
    //web端应用列表
    List<CommPubInfoPageListVo> findWebPageList(CommPubInfoPageListPo po);
    //查询是否符合上下架要求
    List<CommPubInfo> batchSelect(@Param("ids") List<String> ids,@Param("state") String state);
}