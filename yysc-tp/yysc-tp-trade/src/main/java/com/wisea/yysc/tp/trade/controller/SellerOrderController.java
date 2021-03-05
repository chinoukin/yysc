package com.wisea.yysc.tp.trade.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.OrdInvoUpdatePo;
import com.wisea.yysc.common.po.trade.OrderCancelPo;
import com.wisea.yysc.common.po.trade.SellerOrderExpPo;
import com.wisea.yysc.common.po.trade.SureOrderPo;
import com.wisea.yysc.common.po.trade.UpdateQuotedPo;
import com.wisea.yysc.tp.trade.service.SellerOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "【卖家,后台】订单信息")
@RestController
@RequestMapping("/w/seller")
public class SellerOrderController {

    @Autowired
    SellerOrderService sellerOrderService;

    /**
     * 修改报价
     *
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/updateQuoted", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家修改报价", value = "【订单】卖家修改报价", notes = "卖家修改报价", httpMethod = "POST")
    public ResultPoJo<?> updateQuoted(@RequestBody UpdateQuotedPo po) {
        return sellerOrderService.updateQuoted(po);
    }

    /**
     * 订单备注
     *
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/remarkOrder", method = RequestMethod.POST)
    @ApiOperation(nickname = "订单备注", value = "【订单】卖家订单备注", notes = "订单备注", httpMethod = "POST")
    public ResultPoJo<?> remarkOrder(@RequestBody UpdateQuotedPo po) {
        return sellerOrderService.remarkOrder(po);
    }

    /**
     * 订单取消
     *
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ApiOperation(nickname = "取消订单", value = "【订单】卖家取消订单", notes = "订单备注", httpMethod = "POST")
    public ResultPoJo<?> cancelOrder(@RequestBody OrderCancelPo po) {
        return sellerOrderService.cancelOrder(po);
    }

    /**
     * 修改发票
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/updateInvoic", method = RequestMethod.POST)
    @ApiOperation(nickname = "卖家修改发票", value = "【订单】卖家修改发票", notes = "卖家修改发票", httpMethod = "POST")
    public ResultPoJo<?> updateInvoic(@RequestBody OrdInvoUpdatePo ordInvoUpdatePo) {
        return sellerOrderService.updateInvoic(ordInvoUpdatePo);
    }

    /**
     * 确认订单
     *
     * @param
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/sureOrder", method = RequestMethod.POST)
    @ApiOperation(nickname = "确认订单", value = "【订单】卖家修确认订单", notes = "卖家确认订单", httpMethod = "POST")
    public ResultPoJo<?> sureOrder(@RequestBody SureOrderPo sureOrderPo) {
        return sellerOrderService.sureOrder(sureOrderPo);
    }

    /**
     * 导出订单列表
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "导出后台订单列表(后台)", value = "导出后台订单列表(后台)", notes = "导出后台订单列表(后台)", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value = "/orderListExp", method = RequestMethod.POST)
    public void orderListExp(@RequestBody SellerOrderExpPo po, HttpServletResponse response) throws IOException {
        sellerOrderService.orderListExp(po, response);
    }


}
