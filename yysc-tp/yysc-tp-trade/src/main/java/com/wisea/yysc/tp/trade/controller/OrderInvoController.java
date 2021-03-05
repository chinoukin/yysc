package com.wisea.yysc.tp.trade.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.po.trade.InvoicingPo;
import com.wisea.yysc.common.po.trade.OrderInvoPageListPo;
import com.wisea.yysc.common.vo.OrdInvoGetVo;
import com.wisea.yysc.common.vo.trade.OrderInfoResultVo;
import com.wisea.yysc.common.vo.trade.OrderInvoPageListVo;
import com.wisea.yysc.tp.trade.service.OrderInvoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SettleBillInvoController
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Api(tags = "【后台】 发票管理接口")
@RestController
@RequestMapping("/w/invoc")
public class OrderInvoController {
    @Autowired
    private OrderInvoService orderInvoService;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SettleBillInvo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<OrderInfoResultVo<OrderInvoPageListVo>> findPageList(@RequestBody OrderInvoPageListPo orderInvoPageListPo) {
        return orderInvoService.findPageList(orderInvoPageListPo);
    }

    /**
     * 查询发票详情
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<OrdInvoGetVo> findInfo(@RequestBody LongIdPo po) {
        return orderInvoService.findInfo(po);
    }

    /**
     * 订单开票
     *
     * @param invoicingPo
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/invoicing", method = RequestMethod.POST)
    @ApiOperation(nickname = "订单开票", value = "订单开票", notes = "订单开票", httpMethod = "POST")
    public ResultPoJo<?> invoicing(@RequestBody InvoicingPo invoicingPo) {
        return orderInvoService.invoicing(invoicingPo);
    }
}
