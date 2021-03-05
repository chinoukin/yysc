package com.wisea.yysc.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.po.product.CommAttriMagePageListPo;
import com.wisea.yysc.common.po.product.CommAttriMagePo;
import com.wisea.yysc.common.vo.product.CommAttriMageInfoVo;
import com.wisea.yysc.common.vo.product.CommAttriMagePageListVo;
import com.wisea.yysc.tp.product.service.CommAttriMageService;
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
 * @className CommAttriMageController
 * @date 2021/01/28 14:49:36
 * @Description 
 */
@Api(tags = "后台--商品属性管理")
@RestController
@RequestMapping("/w/CommAttriMage")
public class CommAttriMageController {
    @Autowired
    private CommAttriMageService service;

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 分页查询CommAttriMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<CommAttriMagePageListVo>> findPageList(@RequestBody CommAttriMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 逻辑删除CommAttriMage
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 新增或修改CommAttriMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody CommAttriMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 查询详细信息CommAttriMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<CommAttriMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}