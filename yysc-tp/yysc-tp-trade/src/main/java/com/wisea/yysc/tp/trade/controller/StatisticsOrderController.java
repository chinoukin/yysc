package com.wisea.yysc.tp.trade.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.trade.StaticOrderPo;
import com.wisea.yysc.common.vo.trade.*;
import com.wisea.yysc.tp.trade.service.StatisticsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "【后台】首页统计内容")
@RestController
@RequestMapping("/w/statistics")
public class StatisticsOrderController {


    @Autowired
    StatisticsOrderService statisticsOrderService;

    /**
     * 查询首页信息
     *
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/dayStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "首页交易统计", value = "首页今日交易统计", notes = "首页今日交易统计", httpMethod = "POST")
    public ResultPoJo<DayStatisticsVo> yesterdayStatistics() {
        return statisticsOrderService.yesterdayStatistics();
    }

    /**
     * 代办事项
     *
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/orderStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "交易首页-订单状态数量", value = "交易首页-订单状态数量", notes = "交易首页-订单状态数量", httpMethod = "POST")
    public ResultPoJo<OrderStatisticsVo> orderStatistics() {
        return statisticsOrderService.orderStatistics();
    }

    /**
     * 财务 订单统计
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "财务 订单统计", value = "财务 订单统计", notes = "订单统计", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value = "/statisOrder", method = RequestMethod.POST)
    public ResultPoJo<StatisOrderVo> statisOrder(@RequestBody StaticOrderPo po) {
        return statisticsOrderService.statisOrder(po);
    }

    /**
     * 导出财务订单统计数据
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "导出财务订单统计数据(后台)", value = "导出财务订单统计数据(后台)", notes = "导出财务订单统计数据(后台)", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value = "/ordExp", method = RequestMethod.POST)
    public void ordExp(@RequestBody StaticOrderPo po, HttpServletResponse response) throws IOException {
        statisticsOrderService.ordExp(po, response);
    }

    /**
     * 查询首页用户统计信息
     *
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/membStatis", method = RequestMethod.POST)
    @ApiOperation(nickname = "首页用户统计信息", value = "首页用户统计信息", notes = "首页用户统计信息", httpMethod = "POST")
    public ResultPoJo<MembStatisticVo> membStatis() {
        return statisticsOrderService.membStatis();
    }

    /**
     * 【统计】订单数量统计
     *
     * @return
     */
    @RequestMapping(value = "/orderCountStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "【统计】订单数量统计", value = "【统计】订单数量统计", notes = "【统计】订单数量统计", httpMethod = "POST")
    public ResultPoJo<OrderCountStatisticsVo> orderCountStatistics() {
        return statisticsOrderService.orderCountStatistics();
    }

    /**
     * 【统计】销售金额统计
     *
     * @return
     */
    @RequestMapping(value = "/orderAmounStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "【统计】销售金额统计", value = "【统计】销售金额统计", notes = "【统计】销售金额统计", httpMethod = "POST")
    public ResultPoJo<OrderAmounStatisticsVo> orderAmounStatistics() {
        return statisticsOrderService.orderAmounStatistics();
    }
}
