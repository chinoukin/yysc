package com.wisea.yysc.tp.trade.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.trade.*;
import com.wisea.yysc.common.vo.trade.BuyerGeneratingOrderVo;
import com.wisea.yysc.common.vo.trade.BuyerInfoListVo;
import com.wisea.yysc.common.vo.trade.OrderInfoResultVo;
import com.wisea.yysc.common.vo.trade.OrdersInfoVo;
import com.wisea.yysc.tp.trade.service.BuyerOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "【买家】订单接口")
@RestController
@RequestMapping("/w/buyer")
public class BuyerOrderController {

    @Autowired
    private BuyerOrderService buyerOrderService;

    /**
     * 查询订单列表
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/list", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询订单列表", value = "查询订单列表", notes = "查询订单列表", httpMethod = "POST")
    public ResultPoJo<OrderInfoResultVo<BuyerInfoListVo>> findBuyerOrderList(@RequestBody BuyerOrderListPo buyerOrderListPo) {
        return buyerOrderService.findBuyerOrderList(buyerOrderListPo);
    }

    /**
     * 订单详情
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/info", method = RequestMethod.POST)
    @ApiOperation(nickname = "买家查询订单详情", value = "买家查询订单详情", notes = "买家查询订单详情", httpMethod = "POST")
    public ResultPoJo<OrdersInfoVo> findBuyerOrderInfo(@RequestBody OrdersInfoPo ordersInfoPo) {
        return buyerOrderService.findBuyerOrderInfo(ordersInfoPo);
    }

    /**
     * 去支付页面
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/order/pay", method = RequestMethod.POST)
    @ApiOperation(nickname = "去支付页面", value = "去支付页面", notes = "去支付", httpMethod = "POST")
    public ResultPoJo<OrdersInfoVo> findBuyerOrder(@RequestBody OrdersInfoPo ordersInfoPo) {
        return buyerOrderService.findBuyerOrder(ordersInfoPo);
    }


    /**
     * 提交订单
     *
     * @param
     * @return
     */
    @ApiOperation(value = "提交订单", notes = "提交订单")
    @RequestMapping(value = "/generatingOrder", method = RequestMethod.POST)
    public ResultPoJo<BuyerGeneratingOrderVo> generatingOrder(@RequestBody BuyerGeneratingOrderPo po) {
        return buyerOrderService.generatingOrder(po);
    }

    /**
     * 上传支付凭证
     *
     * @param
     * @return
     */
    @ApiOperation(value = "上传支付凭证", notes = "上传支付凭证")
    @RequestMapping(value = "/uploadPayImage", method = RequestMethod.POST)
    public ResultPoJo<Object> uploadPayImage(@RequestBody EleInvoUploadPo eleInvoUploadPo) {
        return buyerOrderService.uploadPayImage(eleInvoUploadPo);
    }

    /**
     * 取消订单
     *
     * @param
     * @return
     */
    @ApiOperation(value = "取消订单", notes = "取消订单")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public ResultPoJo<Object> cancelOrder(@RequestBody OrderCancelPo orderCancelPo) {
        return buyerOrderService.cancelOrder(orderCancelPo);
    }


}
