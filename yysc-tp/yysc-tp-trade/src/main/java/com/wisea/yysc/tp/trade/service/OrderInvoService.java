package com.wisea.yysc.tp.trade.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.EleInvoFileMapper;
import com.wisea.yysc.common.dao.OrdInvoMapper;
import com.wisea.yysc.common.entity.EleInvoFile;
import com.wisea.yysc.common.entity.OrdInvo;
import com.wisea.yysc.common.po.trade.InvoicingPo;
import com.wisea.yysc.common.po.trade.OrderInvoPageListPo;
import com.wisea.yysc.common.vo.OrdInvoGetVo;
import com.wisea.yysc.common.vo.trade.OrderInfoResultVo;
import com.wisea.yysc.common.vo.trade.OrderInvoPageListVo;
import com.wisea.yysc.tp.trade.constants.OrdOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SettleBillInvoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class OrderInvoService extends BaseService {
    @Autowired
    private OrdInvoMapper ordInvoMapper;
    @Autowired
    private OrdOpreateInfoService ordOpreateInfoService;
    @Autowired
    private EleInvoFileMapper eleInvoFileMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SettleBillInvo
     */
    public ResultPoJo<OrderInfoResultVo<OrderInvoPageListVo>> findPageList(OrderInvoPageListPo orderfoInvoPageListPo) {
        ResultPoJo<OrderInfoResultVo<OrderInvoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        OrderInfoResultVo vo = new OrderInfoResultVo();

        //查询各个订单状态下的数量
        Page<OrderInvoPageListVo> page = orderfoInvoPageListPo.getPage();

        //查询列表
        orderfoInvoPageListPo.setPage(page);
        List<OrderInvoPageListVo> list = ordInvoMapper.findPageList(orderfoInvoPageListPo);

        page.setList(list);
        vo.setPage(page);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 查询发票详情
     *
     * @param po
     * @return
     */
    public ResultPoJo<OrdInvoGetVo> findInfo(LongIdPo po) {
        ResultPoJo<OrdInvoGetVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        OrdInvoGetVo vo = ordInvoMapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 订单开票
     *
     * @param invoicingPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> invoicing(InvoicingPo invoicingPo) {
        ResultPoJo<OrdInvoGetVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        OrdInvo ordInvo = ordInvoMapper.selectByPrimaryKey(invoicingPo.getInvoId());
        if (ConverterUtil.isNotEmpty(ordInvo)) {
            String invoState = ordInvo.getInvoState();
            // 数据字典 判断状态  （待开票）
            if (invoState.equals(DictConstants.INVO_STATE_0)) {
                OrdInvo ordInvos = new OrdInvo();
                ordInvos.setDrawDate(OffsetDateTime.now());
                // 设置发票状态是已开票
                ordInvos.setInvoState(DictConstants.INVO_STATE_2);
                ordInvos.preUpdate();
                ordInvoMapper.updateByPrimaryKey(ordInvos);
                EleInvoFile eleInvoFile = new EleInvoFile();
                eleInvoFile.setEleInvoUrl(invoicingPo.getEleInvoUrl());
                eleInvoFile.setFileType(invoicingPo.getFileType());
                eleInvoFile.setOrdInvoId(ordInvo.getId());
                eleInvoFile.setOrdId(ordInvo.getOrdId());
                eleInvoFile.preInsert();
                eleInvoFileMapper.insertSelective(eleInvoFile);
                // 插入订单操作记录
                ordOpreateInfoService.saveOrdOperate(ordInvo.getOrdId(), OrdOperateEnum.INVOICING, null);
                // 修改数据字典值 当前发票是已开票状态
            } else if (invoState.equals(DictConstants.INVO_STATE_2)) {
                OrdInvo ordInvos = new OrdInvo();
                ordInvos.setDrawDate(OffsetDateTime.now());
                // 设置发票状态是作废
                ordInvos.setInvoState(DictConstants.INVO_STATE_3);
                ordInvos.preUpdate();
                ordInvoMapper.updateByPrimaryKey(ordInvos);
                // 插入订单操作记录,作废发票不做订单记录
                // ordOpreateInfoService.saveOrdOperate(ordInvo.getOrdId(), OrdOperateEnum.INVOICING, null);
                // 修改数据字典值 当前发票是已作废状态
            } else if (invoState.equals(DictConstants.INVO_STATE_3)) {
                // 重新开票 删除旧的电子发票文件
                eleInvoFileMapper.delByInvoId(ordInvo.getId());
                if (ConverterUtil.isNotEmpty(invoicingPo.getEleInvoUrl())) {
                    EleInvoFile eleInvoFile = new EleInvoFile();
                    eleInvoFile.setEleInvoUrl(invoicingPo.getEleInvoUrl());
                    eleInvoFile.setFileType(invoicingPo.getFileType());
                    eleInvoFile.setOrdInvoId(ordInvo.getId());
                    eleInvoFile.setOrdId(ordInvo.getOrdId());
                    eleInvoFile.preInsert();
                    eleInvoFileMapper.insertSelective(eleInvoFile);
                }

            } else {
                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            }
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }
}
