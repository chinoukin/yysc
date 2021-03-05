package com.wisea.yysc.tp.trade.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.tpb.common.pay.notify.handler.PayApiNotifyHandler;
import com.wisea.wechat.request.PayApiRequest;
import com.wisea.wechat.service.WxPayApiService;
import com.wisea.wechat.service.WxRefundApiService;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.*;
import com.wisea.yysc.common.entity.EleInvoFile;
import com.wisea.yysc.common.entity.LevelSpecQuote;
import com.wisea.yysc.common.entity.OrdInvo;
import com.wisea.yysc.common.entity.OrderInfo;
import com.wisea.yysc.common.po.trade.*;
import com.wisea.yysc.common.utils.CodeUtils;
import com.wisea.yysc.common.utils.DeadLineUtils;
import com.wisea.yysc.common.vo.CollAcctMageGetVo;
import com.wisea.yysc.common.vo.OrdInvoGetVo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMageInfoVo;
import com.wisea.yysc.common.vo.product.CommPubInfoInfoVo;
import com.wisea.yysc.common.vo.product.MeasUnitMageInfoVo;
import com.wisea.yysc.common.vo.trade.*;
import com.wisea.yysc.tp.trade.constants.OrdOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Service
public class BuyerOrderService extends PayApiNotifyHandler {

    @Autowired
    OrderInfosMapper orderInfosMapper;
    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    LevelSpecQuoteMapper levelSpecQuoteMapper;
    @Autowired
    OrdOpreateInfoService ordOpreateInfoService;
    @Autowired
    OrdInvoMapper ordInvoMapper;
    @Autowired
    MeasUnitMageMapper measUnitMageMapper;
    @Autowired
    WxPayApiService wxPayApiService;
    @Autowired
    WxRefundApiService wxRefundApiService;
    @Autowired
    EleInvoFileMapper eleInvoFileMapper;
    @Autowired
    ApplicationVisitMageMapper applicationVisitMageMapper;
    @Autowired
    CollAcctMageMapper collAcctMageMapper;

    /**
     * 订单列表查询
     *
     * @param buyerOrderListPo
     * @return
     */
    public ResultPoJo<OrderInfoResultVo<BuyerInfoListVo>> findBuyerOrderList(BuyerOrderListPo buyerOrderListPo) {

        ResultPoJo<OrderInfoResultVo<BuyerInfoListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<BuyerInfoListVo> page = buyerOrderListPo.getPage();
        Map<String, Object> stateCountMap = Maps.newHashMap();
        Map<String, Object> stateCount = Maps.newHashMap();
        stateCount.put("0", 0);
        stateCount.put("1", 0);
        stateCount.put("2", 0);
        stateCount.put("3", 0);
        buyerOrderListPo.setPage(null);
        Map<String, Integer> stateCountMap1 = orderInfosMapper.getOrderStateCountMap(buyerOrderListPo);
        stateCountMap.put("result", stateCountMap1);
        stateCountMap.put("stateCount", stateCount);
        buyerOrderListPo.setPage(page);
        List<BuyerInfoListVo> infoListVo = orderInfosMapper.findOrderList(buyerOrderListPo);
        infoListVo.forEach(e -> {
            if (ConverterUtil.isNotEmpty(e.getApplicationVisitId())) {
                LongIdPo longIdPo = new LongIdPo();
                longIdPo.setId(e.getApplicationVisitId());
                ApplicationVisitMageInfoVo info = applicationVisitMageMapper.findInfo(longIdPo);
                info.setRegistTel(e.getRegistTel());
                e.setApplicationVisitMageInfoVo(info);
            }
        });
        page.setList(infoListVo);
        OrderInfoResultVo<BuyerInfoListVo> vo = new OrderInfoResultVo();
        vo.setPage(page);
        vo.setStateCountMap(stateCountMap);
        result.setResult(vo);

        return result;
    }

    /**
     * 订单详情
     *
     * @param ordersInfoPo
     * @return
     */
    public ResultPoJo<OrdersInfoVo> findBuyerOrderInfo(OrdersInfoPo ordersInfoPo) {

        ResultPoJo<OrdersInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrdersInfoVo vo = orderInfosMapper.findOrderInfo(ordersInfoPo);
        if (ConverterUtil.isNotEmpty(vo)) {
            vo.setNowDateTime(OffsetDateTime.now());
            resultPoJo.setResult(vo);
            EleInvoFileInfoVo eleInvoFileInfoVos = eleInvoFileMapper.ordIdFiles(vo.getId());
            if (ConverterUtil.isNotEmpty(eleInvoFileInfoVos)) {
                vo.setEleInvoUrl(eleInvoFileInfoVos.getEleInvoUrl());
            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 去支付,微信支付
     *
     * @param ordersInfoPo
     * @return
     */
    public ResultPoJo<OrdersInfoVo> findBuyerOrder(OrdersInfoPo ordersInfoPo) {

        ResultPoJo<OrdersInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OffsetDateTime now = OffsetDateTime.now();
        CollAcctMageGetVo acctMageGetVo = collAcctMageMapper.findInfo();
        OrdersInfoVo vo = orderInfosMapper.findOrderInfo(ordersInfoPo);
        if (ConverterUtil.isNotEmpty(vo) && now.compareTo(vo.getPayDeadLineDate()) < 0) {
            PayApiRequest payRequest = new PayApiRequest();
            // 应付金额
            payRequest.setAmount(String.valueOf(vo.getAmountPayable()));
            // 设置订单id
            payRequest.setOrderId(vo.getId().toString());
            payRequest.setTranType("3");
            try {
                ResultPoJo<Object> objectResultPoJo = wxPayApiService.nativePay(payRequest);
                vo.setPoJo(objectResultPoJo);
                vo.setRecipientName(acctMageGetVo.getAcctName());
                resultPoJo.setResult(vo);
            } catch (Exception e) {
                e.printStackTrace();
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
        if (ConverterUtil.isNotEmpty(orderInfo) && orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)) {
            // 修改订单状态;
            orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_3);
            if (ConverterUtil.isNotEmpty(orderCancelPo.getOrderCanceId())) {
                orderInfo.setOrdCancelReasonId(orderCancelPo.getOrderCanceId());
            }
            orderInfosMapper.updateByPrimaryKeySelective(orderInfo);
            // 向订单日志表中更新记录;
            ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.CANCEL, MessageFormat.format("{0}，操作备注：{1}", orderCancelPo.getOrderRemark(), "无"));
//            if (orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_4)) {
//                // 已经支付的 退回订单金额, 未支付的订单,直接取消
//                RefundRequest refundRequest = new RefundRequest();
//                refundRequest.setOrderId(orderCancelPo.getOrderId().toString());
//                Double roundValue = ConverterUtil.getRoundValue(ConverterUtil.mul(orderInfo.getCommTotalCount(), orderInfo.getCommTotalPrice()), 2);
//                refundRequest.setAmount(roundValue.toString());
//                refundRequest.setOrderId(orderInfo.getId().toString());
//                wxRefundApiService.refund(refundRequest);
//            }
        } else {
            resultPoJo.setCode(ConstantCodeMsg.ERR_344);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_344);
        }
        return resultPoJo;
    }

    /**
     * 上传付款凭证
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> uploadPayImage(EleInvoUploadPo eleInvoUploadPo) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        EleInvoFile eleInvoFile = new EleInvoFile();
        eleInvoFile.setFileType("1");
        eleInvoFile.setEleInvoUrl(eleInvoUploadPo.getEleInvoUrl());
        eleInvoFile.setOrdId(eleInvoUploadPo.getOrderId());
        eleInvoFile.preInsert();
        eleInvoFileMapper.insertSelective(eleInvoFile);
        return resultPoJo;
    }


    /**
     * 提交订单
     *
     * @param buyerGeneratingOrderPo
     * @return
     */
    public ResultPoJo<BuyerGeneratingOrderVo> generatingOrder(BuyerGeneratingOrderPo buyerGeneratingOrderPo) {

        ResultPoJo<BuyerGeneratingOrderVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BuyerGeneratingOrderVo buyerGeneratingOrderVo = new BuyerGeneratingOrderVo();
        PayApiRequest payRequest = new PayApiRequest();
        LongIdPo longIdPo = new LongIdPo();
        longIdPo.setId(buyerGeneratingOrderPo.getCommPubId());
        CollAcctMageGetVo acctMageGetVo = collAcctMageMapper.findInfo();
        CommPubInfoInfoVo info = commPubInfoMapper.findInfo(longIdPo);
        LevelSpecQuote levelSpecQuote = levelSpecQuoteMapper.selectByPrimaryKey(buyerGeneratingOrderPo.getLevelSpecId());
        longIdPo.setId(levelSpecQuote.getMeasUnitId());
        MeasUnitMageInfoVo measUnitInfo = measUnitMageMapper.findInfo(longIdPo);
        User user = SystemUtils.getUserOnlyId();
//        Long membId = MembUtils.getMembInfoByUserId(user.getId()).getMembId();
        Long membId = user.getId();
        // 根据买方id 查询试用订单是否存在,存在就不能在次试用了;
        List<OrdersInfoVo> ordersInfoVo = orderInfosMapper.selOrdertryList(membId);
        if (ConverterUtil.isNotEmpty(ordersInfoVo) && buyerGeneratingOrderPo.getTryOrdType().equals("0")) {
            resultPoJo.setCode(ConstantCodeMsg.ERR_345);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_345);
            return resultPoJo;
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setBuyerId(membId);
        orderInfo.setSellerId(info.getMembId());
        orderInfo.setCommPubId(buyerGeneratingOrderPo.getCommPubId());
        orderInfo.setOrdNum(CodeUtils.generateOrderCode());
        orderInfo.setCommTotalCount(buyerGeneratingOrderPo.getCommCount());
        orderInfo.setCommTotalPrice(levelSpecQuote.getPrice());
        // 字典值 现阶段全是web 端
        orderInfo.setSourceType("0");

        if (ConverterUtil.isNotEmpty(buyerGeneratingOrderPo.getOrdRemarks())) {
            orderInfo.setOrdRemarks(buyerGeneratingOrderPo.getOrdRemarks());
        }
        orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_0);
        OffsetDateTime dateNow = OffsetDateTimeUtils.getDateTimeNow();
        orderInfo.setReferOrdDate(dateNow);
        orderInfo.setLevelSpecId(buyerGeneratingOrderPo.getLevelSpecId());
        // 付款截止时间
        Integer minutes = DeadLineUtils.getLimitDaysByType();
        if (buyerGeneratingOrderPo.getTryOrdType().equals("0")) {
            // 试用订单
            orderInfo.setPayDeadLineDate(dateNow.plusMinutes(minutes));
            orderInfo.setTryOrdType(buyerGeneratingOrderPo.getTryOrdType());
            orderInfo.setValidStartDate(OffsetDateTimeUtils.getDayMinTime(dateNow));
            orderInfo.setValidEndDate(dateNow.plusDays(7));
            // 应付款金额
            orderInfo.setAmountPayable(0.0);
            orderInfo.preInsert();
            orderInfosMapper.insertSelective(orderInfo);
            // 订单操作表
            ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.SUBMIT, orderInfo.getRemarks());
            // 组装返回信息
            buyerGeneratingOrderVo.setAmountPayable(0);
            buyerGeneratingOrderVo.setCommPubName(info.getCommTitle());
            buyerGeneratingOrderVo.setOrderNum(orderInfo.getOrdNum());
            buyerGeneratingOrderVo.setTotalCount(buyerGeneratingOrderPo.getCommCount());
            buyerGeneratingOrderVo.setReferOrdDate(orderInfo.getReferOrdDate());
            buyerGeneratingOrderVo.setLimitTime(minutes);
            buyerGeneratingOrderVo.setRecipientName(acctMageGetVo.getAcctName());
            // 设置订单id
            payRequest.setOrderId(orderInfo.getId().toString());
            // 应付金额
            payRequest.setAmount("0.00");
        } else if (buyerGeneratingOrderPo.getTryOrdType().equals("1") && buyerGeneratingOrderPo.getPayMethodType().equals("0")) {

            orderInfo.setValidStartDate(OffsetDateTimeUtils.getDayMinTime(dateNow));
            validEndDate(buyerGeneratingOrderPo, measUnitInfo, ordersInfoVo, orderInfo, dateNow);
            double totalPrice = getOrderInfoTotalPrice(buyerGeneratingOrderPo, levelSpecQuote, orderInfo, dateNow, minutes);

            // 组装返回信息
            buyerGeneratingOrderVo.setAmountPayable(ConverterUtil.getRoundValue(totalPrice, 2));
            buyerGeneratingOrderVo.setCommPubName(info.getCommTitle());
            buyerGeneratingOrderVo.setOrderNum(orderInfo.getOrdNum());
            buyerGeneratingOrderVo.setTotalCount(buyerGeneratingOrderPo.getCommCount());
            buyerGeneratingOrderVo.setReferOrdDate(orderInfo.getReferOrdDate());
            buyerGeneratingOrderVo.setPayDeadLineDate(dateNow.plusMinutes(minutes));
            buyerGeneratingOrderVo.setRecipientName(acctMageGetVo.getAcctName());
            // 应付金额
            payRequest.setAmount(String.valueOf(totalPrice));
            // 设置订单id
            payRequest.setOrderId(orderInfo.getId().toString());
            payRequest.setTranType("3");
            try {
                ResultPoJo<Object> objectResultPoJo = wxPayApiService.nativePay(payRequest);
                buyerGeneratingOrderVo.setPoJo(objectResultPoJo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 线下订单
            double totalPrice = getOrderInfoTotalPrice(buyerGeneratingOrderPo, levelSpecQuote, orderInfo, dateNow, minutes);
            buyerGeneratingOrderVo.setAmountPayable(ConverterUtil.getRoundValue(totalPrice, 2));
            buyerGeneratingOrderVo.setCommPubName(info.getCommTitle());
            buyerGeneratingOrderVo.setOrderNum(orderInfo.getOrdNum());
            buyerGeneratingOrderVo.setTotalCount(buyerGeneratingOrderPo.getCommCount());
            buyerGeneratingOrderVo.setReferOrdDate(orderInfo.getReferOrdDate());
            buyerGeneratingOrderVo.setPayDeadLineDate(dateNow.plusMinutes(minutes));
            buyerGeneratingOrderVo.setRecipientName(acctMageGetVo.getAcctName());
            buyerGeneratingOrderVo.setAcctNum(acctMageGetVo.getAcctNum());
            buyerGeneratingOrderVo.setBankDeposit(acctMageGetVo.getBankDeposit());
        }
        resultPoJo.setResult(buyerGeneratingOrderVo);
        return resultPoJo;
    }

    public void validEndDate(BuyerGeneratingOrderPo buyerGeneratingOrderPo, MeasUnitMageInfoVo measUnitInfo, List<OrdersInfoVo> ordersInfoVo, OrderInfo orderInfo, OffsetDateTime dateNow) {
        // 应用最终时间
        OffsetDateTime ultimateTime = null;
        if (ConverterUtil.isNotEmpty(ordersInfoVo)) {
            int compare = dateNow.compareTo(ordersInfoVo.get(0).getValidEndDate());
            if (compare < 0) {
                // 试用订单还没有到期,,应用最终的结束时间需要 + 上剩余时间
                if (measUnitInfo.getDimensionsType().equals(DictConstants.DIMENSIONS_TYPE_5)) {
                    // 当前时间,加上试用期没有结束的时间
                    OffsetDateTime endTime = dateNow.plusDays(Math.abs(compare));
                    if (measUnitInfo.getUnitNum().equals("NIAN")) {
                        ultimateTime = endTime.plusYears(buyerGeneratingOrderPo.getCommCount());
                    } else if (measUnitInfo.getUnitNum().equals("YUE")) {
                        ultimateTime = endTime.plusMonths(buyerGeneratingOrderPo.getCommCount());
                    } else if (measUnitInfo.getUnitNum().equals("ER")) {
                        ultimateTime = endTime.plusDays(buyerGeneratingOrderPo.getCommCount());
                    }
                    orderInfo.setValidEndDate(ultimateTime);
                }
            } else {
                // 试用订单已经到期了,应用结束时间就是 商品购买周期
                if (measUnitInfo.getUnitNum().equals("NIAN")) {
                    ultimateTime = dateNow.plusYears(buyerGeneratingOrderPo.getCommCount());
                } else if (measUnitInfo.getUnitNum().equals("YUE")) {
                    ultimateTime = dateNow.plusMonths(buyerGeneratingOrderPo.getCommCount());
                } else if (measUnitInfo.getUnitNum().equals("ER")) {
                    ultimateTime = dateNow.plusDays(buyerGeneratingOrderPo.getCommCount());
                }
                orderInfo.setValidEndDate(ultimateTime);
            }
        }
    }

    /**
     * 组装订单信息
     *
     * @param buyerGeneratingOrderPo
     * @param levelSpecQuote
     * @param orderInfo
     * @param dateNow
     * @param minutes
     * @return
     */
    private double getOrderInfoTotalPrice(BuyerGeneratingOrderPo buyerGeneratingOrderPo, LevelSpecQuote levelSpecQuote, OrderInfo orderInfo, OffsetDateTime dateNow, Integer minutes) {
        // 正式订单,微信支付
        orderInfo.setPayDeadLineDate(dateNow.plusMinutes(minutes));
        orderInfo.setPayMethodType(buyerGeneratingOrderPo.getPayMethodType());
        orderInfo.setTryOrdType(buyerGeneratingOrderPo.getTryOrdType());
        // 应付款金额
        double totalPrice = ConverterUtil.mul(buyerGeneratingOrderPo.getCommCount(), levelSpecQuote.getPrice());
        orderInfo.setAmountPayable(ConverterUtil.getRoundValue(totalPrice, 2));
        orderInfo.preInsert();
        orderInfosMapper.insertSelective(orderInfo);
        // 订单发票
        if (ConverterUtil.isNotEmpty(buyerGeneratingOrderPo.getInvoId())) {
            LongIdPo longIds = new LongIdPo();
            longIds.setId(buyerGeneratingOrderPo.getInvoId());
            OrdInvoGetVo invoGet = ordInvoMapper.findInfo(longIds);
            OrdInvo ordInvo = new OrdInvo();
            ConverterUtil.copyProperties(invoGet, ordInvo);
            ordInvo.preInsert();
            ordInvoMapper.insertSelective(ordInvo);
        }
        // 初始化 订单操作表
        ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.SUBMIT, orderInfo.getRemarks());
        return totalPrice;
    }

    /**
     * 修改订单状态
     *
     * @param payRecord
     */
    @Override
    protected void handle(com.wisea.tpb.common.pay.entity.PayRecord payRecord) {
        // 修改订单状态
        OrderInfo orderInfo = new OrderInfo();
        OrderInfo orderInfo1 = orderInfosMapper.selectByPrimaryKey(Long.parseLong(payRecord.getOrdId()));
        orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_2);
        orderInfo.setId(Long.parseLong(payRecord.getOrdId()));
        orderInfo.setPayOrdDate(OffsetDateTime.now());
        orderInfosMapper.updateByPrimaryKeySelective(orderInfo);

        // 向订单日志表中更新记录;
        ordOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.PAY, orderInfo1.getAmountPayable().toString());
    }
}
