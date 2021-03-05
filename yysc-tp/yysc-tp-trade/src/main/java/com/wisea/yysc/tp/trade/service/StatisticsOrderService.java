package com.wisea.yysc.tp.trade.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.constants.DictConstants;
import com.wisea.yysc.common.dao.OrderInfosMapper;
import com.wisea.yysc.common.po.trade.StaticOrderPo;
import com.wisea.yysc.common.vo.trade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsOrderService extends BaseService {

    @Autowired
    OrderInfosMapper orderInfosMapper;

    /**
     * 首页统计信息
     *
     * @return
     */
    public ResultPoJo<DayStatisticsVo> yesterdayStatistics() {
        ResultPoJo<DayStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Map<String, Object> paramMap = Maps.newHashMap();

        User user = SystemUtils.getUser();

        // 今天
        paramMap.put("startDate", OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()));
        paramMap.put("endDate", OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));

        // 昨天
        paramMap.put("yesterStartDate", OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().minusDays(1)));
        paramMap.put("yesterEndDate", OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().minusDays(1)));

        // 近七天
        paramMap.put("startTime", OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().minusWeeks(1)));
        paramMap.put("endTime", OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().minusWeeks(1)));

        paramMap.put("sellerId", user.getId());

        DayStatisticsVo vo = orderInfosMapper.dayStatistics(paramMap);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 代办事项
     *
     * @return
     */
    public ResultPoJo<OrderStatisticsVo> orderStatistics() {
        ResultPoJo<OrderStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Map<String, Object> paramMap = Maps.newHashMap();

        User user = SystemUtils.getUser();
        User userOnlyId = SystemUtils.getUserOnlyId();
        paramMap.put("sellerId", userOnlyId.getId());

        OrderStatisticsVo vo = orderInfosMapper.orderStatistics(paramMap);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 订单统计
     *
     * @param po
     * @return
     */
    public ResultPoJo<StatisOrderVo> statisOrder(StaticOrderPo po) {
        ResultPoJo<StatisOrderVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }
        //获取当前用户
        User userOnlyId = SystemUtils.getUserOnlyId();
        Long sellerId = userOnlyId.getId();
        po.setSellerId(sellerId);
        //有效订单数
        Integer effCount = 0;
        Double effAmount = 0D;
        //无效订单
        Integer notCount = 0;
        Double notAmount = 0D;
        //已成交订单
        Integer overCount = 0;
        Double overAmount = 0D;
        List<StatisOrderVo> statisList = orderInfosMapper.statisOrder(po);
        for (StatisOrderVo e : statisList) {
            //无效订单
            if (DictConstants.ORDER_STATE_TYPE_3.equals(e.getOrderStateType())) {

                notCount = e.getEffOrdCount();
                notAmount = e.getEffOrdAmount();
            } else if (DictConstants.ORDER_STATE_TYPE_2.equals(e.getOrderStateType())) {
                //已成交
                overCount = e.getEffOrdCount();
                overAmount = e.getEffOrdAmount();
                effCount = effCount + e.getEffOrdCount();
                effAmount = ConverterUtil.add(effAmount, e.getEffOrdAmount());
            } else {

                effCount = effCount + e.getEffOrdCount();
                effAmount = ConverterUtil.add(effAmount, e.getEffOrdAmount());
            }
        }
        //无效订单
        StatisOrderVo statisOrder = new StatisOrderVo();
        //已成交订单
        statisOrder.setEffOrdAmount(effAmount);
        statisOrder.setEffOrdCount(effCount);
        statisOrder.setNotEffOrdAmount(notAmount);
        statisOrder.setNotEffOrdCount(notCount);
        statisOrder.setOverOrdAmount(overAmount);
        statisOrder.setOverOrdCount(overCount);
        statisOrder.setTotalOrdAmount(ConverterUtil.add(statisOrder.getEffOrdAmount(), statisOrder.getNotEffOrdAmount()));
        resultPoJo.setResult(statisOrder);
        return resultPoJo;
    }

    /**
     * 导出财务订单数据
     *
     * @param po
     * @param response
     * @return
     */
    public void ordExp(StaticOrderPo po, HttpServletResponse response) {

        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }
        // 获取订单列表
        List<StatisOrderVo> statisList = orderInfosMapper.statisOrder(po);

        String fileName = "财务订单统计.xlsx";
        ExportExcel exportExcel = new ExportExcel("财务订单统计", OrdExpVo.class);
        try {
            exportExcel.setDataList(statisList).writeWithAjaxHeader(response, fileName).dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户统计
     */
    public ResultPoJo<MembStatisticVo> membStatis() {

        ResultPoJo<MembStatisticVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Map<String, Object> paramMap = Maps.newHashMap();

        // TODO 需要获取用户的id
        User userOnlyId = SystemUtils.getUserOnlyId();
        Long sellerId = userOnlyId.getId();

        // 今天
        paramMap.put("startDate", OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()));
        paramMap.put("endDate", OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));

        // 昨天
        paramMap.put("yesterDate", OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().minusDays(1)));
        paramMap.put("yesterEndDate", OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().minusDays(1)));

        // 近一月
        int year = OffsetDateTime.now().getYear();
        int monthValue = OffsetDateTime.now().getMonthValue();
        paramMap.put("monthDate", OffsetDateTimeUtils.getFirstDayOfMonth(year, monthValue));
        paramMap.put("monthDateEnd", OffsetDateTimeUtils.getLastDayOfMonth(year, monthValue));
        paramMap.put("sellerId", sellerId);

        MembStatisticVo membStatisticVo = orderInfosMapper.membStatistics(paramMap);
        resultPoJo.setResult(membStatisticVo);
        return resultPoJo;

    }

    /**
     * 【统计】订单数量统计
     *
     * @return
     */
    public ResultPoJo<OrderCountStatisticsVo> orderCountStatistics() {
        LoggerUtil.infoWithContext("【orderCountStatistics】订单数量统计：", null);
        ResultPoJo<OrderCountStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        Map<String, Object> paramMap = Maps.newHashMap();
        if (Constants.USER_TYPE_USER.equals(user.getUserType()) || Constants.USER_TYPE_SUBUSER.equals(user.getUserType())) {
            //卖家查询订单数量统计
            paramMap.put("sellerId", ConverterUtil.isEmpty(user.getParentId()) ? user.getId() : user.getParentId());
        }
        OrderCountStatisticsVo vo = orderInfosMapper.orderCountStatistics(paramMap);
        double div1 = 0;
        if (vo.getLastWeekOrderCount() > 0) {
            div1 = ConverterUtil.div(ConverterUtil.sub(vo.getThisWeekOrderCount(), vo.getLastWeekOrderCount()), vo.getLastWeekOrderCount(), 2);
        } else {
            if (vo.getThisWeekOrderCount() > 0) {
                div1 = 1;
            } else {
                div1 = 0;
            }
        }
        vo.setRingRatioLastWeek(ConverterUtil.getRoundValue(ConverterUtil.mul(div1, 100), 0).intValue());

        double div2 = 0;
        if (vo.getLastMonthOrderCount() > 0) {
            div2 = ConverterUtil.div(ConverterUtil.sub(vo.getThisMonthOrderCount(), vo.getLastMonthOrderCount()), vo.getLastMonthOrderCount(), 2);
        } else {
            if (vo.getThisMonthOrderCount() > 0) {
                div2 = 1;
            } else {
                div2 = 0;
            }
        }
        vo.setRingRatioLastMonth(ConverterUtil.getRoundValue(ConverterUtil.mul(div2, 100), 0).intValue());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 【统计】销售金额统计
     *
     * @return
     */
    public ResultPoJo<OrderAmounStatisticsVo> orderAmounStatistics() {
        LoggerUtil.infoWithContext("【orderAmounStatistics】销售金额统计：", null);
        ResultPoJo<OrderAmounStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        Map<String, Object> paramMap = Maps.newHashMap();
        if (Constants.USER_TYPE_USER.equals(user.getUserType()) || Constants.USER_TYPE_SUBUSER.equals(user.getUserType())) {
            //卖家查询订单金额统计
            paramMap.put("sellerId", ConverterUtil.isEmpty(user.getParentId()) ? user.getId() : user.getParentId());
        }
        OrderAmounStatisticsVo vo = orderInfosMapper.orderAmounStatistics(paramMap);

        double div1 = 0;
        if (vo.getLastWeekOrderAmoun() > 0) {
            div1 = ConverterUtil.div(ConverterUtil.sub(vo.getThisWeekOrderAmoun(), vo.getLastWeekOrderAmoun()), vo.getLastWeekOrderAmoun(), 2);
        } else {
            if (vo.getThisWeekOrderAmoun() > 0) {
                div1 = 1;
            } else {
                div1 = 0;
            }
        }
        vo.setRingRatioLastWeek(ConverterUtil.getRoundValue(ConverterUtil.mul(div1, 100), 0).intValue());

        double div2 = 0;
        if (vo.getLastMonthOrderAmoun() > 0) {
            div2 = ConverterUtil.div(ConverterUtil.sub(vo.getThisMonthOrderAmoun(), vo.getLastMonthOrderAmoun()), vo.getLastMonthOrderAmoun(), 2);
        } else {
            if (vo.getThisMonthOrderAmoun() > 0) {
                div2 = 1;
            } else {
                div2 = 0;
            }
        }
        vo.setRingRatioLastMonth(ConverterUtil.getRoundValue(ConverterUtil.mul(div2, 100), 0).intValue());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

}
