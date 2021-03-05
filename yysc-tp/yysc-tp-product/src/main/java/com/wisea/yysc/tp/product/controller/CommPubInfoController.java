package com.wisea.yysc.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.po.product.CommPubInfoBatchDelPo;
import com.wisea.yysc.common.po.product.CommPubInfoPageListPo;
import com.wisea.yysc.common.po.product.CommPubInfoPo;
import com.wisea.yysc.common.vo.product.CommPubInfoInfoVo;
import com.wisea.yysc.common.vo.product.CommPubInfoPageListVo;
import com.wisea.yysc.common.vo.product.NewApplicationsVo;
import com.wisea.yysc.tp.product.service.CommPubInfoService;
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
 * @className CommPubInfoController
 * @date 2021/01/29 14:48:32
 * @Description 
 */
@Api(tags = "应用列表")
@RestController
@RequestMapping("/w/CommPubInfo")
public class CommPubInfoController {
    @Autowired
    private CommPubInfoService service;

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 分页查询CommPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<CommPubInfoPageListVo>> findPageList(@RequestBody CommPubInfoPageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 逻辑删除CommPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 新增或修改CommPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody CommPubInfoPo po) {
        return service.saveOrUpdate(po);
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
        return service.findInfo(po, "1");
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 上下架操作CommPubInfo
     */
    @DataCheck
    @RequestMapping(value = "/batchDel", method = RequestMethod.POST)
    @ApiOperation(nickname = "上下架操作", value = "上下架操作", notes = "上下架操作", httpMethod = "POST")
    public ResultPoJo batchDel(@RequestBody CommPubInfoBatchDelPo po) {
        return service.batchDel(po);
    }


    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 新增应用
     */
    @DataCheck
    @RequestMapping(value = "/newApplications", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增应用前", value = "新增应用前", notes = "新增应用前", httpMethod = "POST")
    public ResultPoJo<NewApplicationsVo> newApplications(@RequestBody LongIdPo po) {
        return service.newApplications(po);
    }




}