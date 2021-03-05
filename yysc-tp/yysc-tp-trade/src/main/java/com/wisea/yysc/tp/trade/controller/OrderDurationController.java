package com.wisea.yysc.tp.trade.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.entity.DeadLineMage;
import com.wisea.yysc.tp.trade.service.OrderDurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "【后台】订单期限接口")
@RestController
@RequestMapping("/w/orderDuration")
public class OrderDurationController {

    @Autowired
    OrderDurationService orderDurationService;

    /**
     * 查询订单期限
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询订单期限", value = "查询订单期限", notes = "查询订单期限", httpMethod = "POST")
    public ResultPoJo<DeadLineMage> findBuyerOrderList() {
        return orderDurationService.getDeadLineMage();
    }

    /**
     * 订单期限设置
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "保存,修改订单期限", value = "保存,修改订单期限", notes = "保存,修改订单期限", httpMethod = "POST")
    public ResultPoJo<?> findBuyerOrderList(@RequestBody DeadLineMage deadLineMage) {
        return orderDurationService.saveOrUpdate(deadLineMage);
    }

}
