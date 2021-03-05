package com.wisea.yysc.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.po.product.CommPubInfoPageListPo;
import com.wisea.yysc.common.vo.product.CommPubInfoInfoVo;
import com.wisea.yysc.common.vo.product.WebPageListVo;
import com.wisea.yysc.tp.product.service.CommPubInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "无权限--前台应用")
@RestController
@RequestMapping("/n/NoAutCommPubInfo")
public class  NoAutCommPubInfoController {

    @Autowired
    private CommPubInfoService service;

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description web端应用列表
     */
    @DataCheck
    @RequestMapping(value = "/findWebPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "web端应用列表", value = "web端应用列表", notes = "web端应用列表", httpMethod = "POST")
    public ResultPoJo<List<WebPageListVo>> findWebPageList(@RequestBody CommPubInfoPageListPo po) {
        return service.findWebPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 查询详细信息CommPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<CommPubInfoInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po,"0");
    }
}
