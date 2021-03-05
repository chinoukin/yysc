package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.EleInvoFile;
import com.wisea.yysc.common.po.EleInvoFileListPo;
import com.wisea.yysc.common.po.EleInvoFilePagePo;
import com.wisea.yysc.common.vo.EleInvoFileListVo;
import com.wisea.yysc.common.vo.trade.EleInvoFileInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ele_invo_file 表DAO
 * 电子发票文件
 * 2021/01/26 16:30:07
 */
@Repository
public interface EleInvoFileMapper extends CrudDao<EleInvoFile> {
    List<EleInvoFileListVo> findPage(EleInvoFilePagePo eleInvoFilePagePo);

    List<EleInvoFileListVo> findList(EleInvoFileListPo eleInvoFileListPo);

    /**
     * @Description 根据发票ID删除电子发票文件
     **/
    void delByInvoId(@Param("invoId") Long id);

    /**
     * 根据订单发票ID查询发票文件
     *
     * @param id
     * @return
     */
    List<EleInvoFileInfoVo> ordInvoFiles(Long id);

    /**
     * 根据订单ID查询发票文件
     *
     * @param id
     * @return
     */
    EleInvoFileInfoVo ordIdFiles(Long id);
}