package com.wisea.yysc.tp.trade.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.*;
import com.wisea.yysc.common.entity.LevelSpecQuote;
import com.wisea.yysc.common.entity.OrdInvo;
import com.wisea.yysc.common.entity.OrderInfo;
import com.wisea.yysc.common.po.OrdInvoUpdatePo;
import com.wisea.yysc.common.po.trade.*;
import com.wisea.yysc.common.vo.OrdInvoGetVo;
import com.wisea.yysc.common.vo.product.MeasUnitMageInfoVo;
import com.wisea.yysc.common.vo.trade.OrderListExpVo;
import com.wisea.yysc.common.vo.trade.OrdersInfoVo;
import com.wisea.yysc.common.vo.trade.SellerOrderListVo;
import com.wisea.yysc.tp.trade.constants.OrdOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * 卖家订单信息
 */
@Service
public class SellerOrderService {

    @Autowired
    OrderInfosMapper orderInfosMapper;
    @Autowired
    OrdInvoMapper ordInvoMapper;
    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    MeasUnitMageMapper measUnitMageMapper;
    @Autowired
    LevelSpecQuoteMapper levelSpecQuoteMapper;
    @Autowired
    BuyerOrderService buyerOrderService;
    @Autowired
    OrdOpreateInfoService ordOpreateInfoService;

    /**
     * 修改订单费用信息
     *
     * @param updateQuotedPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> updateQuoted(UpdateQuotedPo updateQuotedPo) {
        ResultPoJo<OrdersInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfo orderInfo = orderInfosMapper.selectByPrimaryKey(updateQuotedPo.getOrdId());
        if (ConverterUtil.isNotEmpty(orderInfo)) {
            // 只有待付款 能修改订单金额
            if (orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)) {
                orderInfo.setAmountPayable(updateQuotedPo.getWeightPrice());
                orderInfo.preUpdate();
                orderInfosMapper.updateByPrimaryKey(orderInfo);
                // 插入订单操作记录
                ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.EDITFREE, MessageFormat.format("{0}，修改费用信息：{1}", updateQuotedPo.getWeightPrice()));
            } else {
                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 修改发票信息
     *
     * @param ordInvoUpdatePo
     * @return
     */
    public ResultPoJo<?> updateInvoic(OrdInvoUpdatePo ordInvoUpdatePo) {

        ResultPoJo<OrdInvoGetVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        OrderInfo orderInfo = orderInfosMapper.selectByPrimaryKey(ordInvoUpdatePo.getOrdId());

        if (ConverterUtil.isNotEmpty(orderInfo)) {
            // 只有待付款 能修改订单金额
            if (orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)) {
                OrdInvo ordInvo = new OrdInvo();
                ConverterUtil.copyProperties(ordInvoUpdatePo, orderInfo);
                ordInvoMapper.updateByPrimaryKey(ordInvo);
            } else {
                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 备注订单信息
     *
     * @param updateQuotedPo
     * @return
     */
    public ResultPoJo<?> remarkOrder(UpdateQuotedPo updateQuotedPo) {

        ResultPoJo<OrdInvoGetVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        OrderInfo orderInfo = orderInfosMapper.selectByPrimaryKey(updateQuotedPo.getOrdId());

        if (ConverterUtil.isNotEmpty(orderInfo)) {
            // 只有待付款 能备注订单
            if (orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)) {
                // 插入订单操作记录
                ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.DELIVE, updateQuotedPo.getOrderReamrk());
            } else {
                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 取消订单
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> cancelOrder(OrderCancelPo orderCancelPo) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfo orderInfo = orderInfosMapper.selectByPrimaryKey(orderCancelPo.getOrderId());
        if (ConverterUtil.isNotEmpty(orderInfo)) {
            // 修改订单状态;
            orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_3);
            if (ConverterUtil.isNotEmpty(orderCancelPo.getOrderCanceId())) {
                orderInfo.setOrdCancelReasonId(orderCancelPo.getOrderCanceId());
            }
            orderInfosMapper.updateByPrimaryKeySelective(orderInfo);
            // 向订单日志表中更新记录;
            ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.CANCELSELLER, MessageFormat.format("{0}，操作备注：{1}", orderCancelPo.getOrderRemark(), "无"));

        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_344);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_344);
        }
        return resultPoJo;
    }

    /**
     * 确认订单信息
     *
     * @param sureOrderPo
     * @return
     */
    public ResultPoJo<?> sureOrder(SureOrderPo sureOrderPo) {

        ResultPoJo<OrdInvoGetVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfo orderInfo = orderInfosMapper.selectByPrimaryKey(sureOrderPo.getId());
        OffsetDateTime now = OffsetDateTime.now();
        // 只有待付款 能修改订单金额
        if (orderInfo.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_2)) {
            orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_2);
            orderInfo.setSellerSureDate(now);
            // 设置应用开始时间及应用结束时间
            orderInfo.setValidStartDate(now);

            LongIdPo longIdPo = new LongIdPo();
            longIdPo.setId(orderInfo.getCommPubId());
            LevelSpecQuote levelSpecQuote = levelSpecQuoteMapper.selectByPrimaryKey(orderInfo.getLevelSpecId());
            longIdPo.setId(levelSpecQuote.getMeasUnitId());
            MeasUnitMageInfoVo measUnitInfo = measUnitMageMapper.findInfo(longIdPo);
            // 根据买方id 查询试用订单是否存在,存在就不能在次试用了;
            List<OrdersInfoVo> ordersInfoVo = orderInfosMapper.selOrdertryList(orderInfo.getBuyerId());
            BuyerGeneratingOrderPo buyerGeneratingOrderPo = new BuyerGeneratingOrderPo();
            buyerGeneratingOrderPo.setCommCount(orderInfo.getCommTotalCount());
            buyerOrderService.validEndDate(buyerGeneratingOrderPo, measUnitInfo, ordersInfoVo, orderInfo, now);
            orderInfo.preUpdate();
            orderInfosMapper.updateByPrimaryKey(orderInfo);
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
        }
        return resultPoJo;
    }

    /**
     * 导出后台订单列表(后台)
     *
     * @param po
     * @return
     */
    public void orderListExp(SellerOrderExpPo po, HttpServletResponse response) throws IOException {
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }
        // 获取订单列表
        List<SellerOrderListVo> findIncomeList = orderInfosMapper.orderListExp(po);

        String fileName = "订单列表.xlsx";
        ExportExcel exportExcel = new ExportExcel("订单列表", OrderListExpVo.class);
        exportExcel.setDataList(findIncomeList).writeWithAjaxHeader(response, fileName).dispose();
    }
}
