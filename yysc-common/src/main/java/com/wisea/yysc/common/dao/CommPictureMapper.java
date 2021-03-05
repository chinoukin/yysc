package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.CommPicture;
import com.wisea.yysc.common.po.CommPictureListPo;
import com.wisea.yysc.common.po.CommPicturePagePo;
import com.wisea.yysc.common.vo.CommPictureListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_picture 表DAO
 * 商品图片信息
 * 2021/01/26 16:30:07
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Mapper
@Repository
public interface CommPictureMapper extends CrudDao<CommPicture> {
    List<CommPictureListVo> findPage(CommPicturePagePo commPicturePagePo);

    List<CommPictureListVo> findList(CommPictureListPo commPictureListPo);

    void deleteByCommPubId(Long id);

}