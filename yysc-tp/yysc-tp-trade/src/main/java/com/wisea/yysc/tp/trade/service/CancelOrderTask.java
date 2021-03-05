package com.wisea.yysc.tp.trade.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.OrderInfosMapper;
import com.wisea.yysc.common.entity.OrderInfo;
import com.wisea.yysc.tp.trade.constants.OrdOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CancelOrderTask {

    @Autowired
    OrdOpreateInfoService ordOpreateService;
    @Autowired
    OrderInfosMapper orderInfosMapper;

    /**
     * 订单付款超时
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> orderCancelTask() {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<OrderInfo> ordList = orderInfosMapper.findPreOutTimeOrders();

        Map<Long, String> orderStateTypeMap = Maps.newHashMap();

        ordList.forEach(e -> {
            if (DictConstants.ORDER_STATE_TYPE_0.equals(e.getOrderStateType())) {
                //插入订单操作记录
                ordOpreateService.saveOrdOperate(e.getId(), OrdOperateEnum.TIMEOUTPAY, "订单待付款超时，自动取消订单");
            }
            orderStateTypeMap.put(e.getId(), e.getOrderStateType());
            e.preUpdate();
            e.setOrdCancelDate(OffsetDateTime.now());
            e.setOrderStateType(DictConstants.ORDER_STATE_TYPE_3);
            orderInfosMapper.updateByPrimaryKey(e);
        });

        return resultPoJo;
    }
}
