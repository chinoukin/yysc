package com.wisea.yysc.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.po.product.ApplicationVisitMagePageListPo;
import com.wisea.yysc.common.po.product.ApplicationVisitMagePo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMageInfoVo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMagePageListVo;
import com.wisea.yysc.tp.product.service.ApplicationVisitMageService;
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
 * @className ApplicationVisitMageController
 * @date 2021/01/28 17:17:49
 * @Description 
 */
@Api(tags = "后台--应用访问配置")
@RestController
@RequestMapping("/w/ApplicationVisitMage")
public class ApplicationVisitMageController {
    @Autowired
    private ApplicationVisitMageService service;

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 分页查询ApplicationVisitMage
     */
    @DataCheck
    @RequestMapping(value = "/findPageList", method = RequestMethod.POST)
    @ApiOperation(nickname = "分页查询列表", value = "分页查询列表", notes = "分页查询列表", httpMethod = "POST")
    public ResultPoJo<Page<ApplicationVisitMagePageListVo>> findPageList(@RequestBody ApplicationVisitMagePageListPo po) {
        return service.findPageList(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 逻辑删除ApplicationVisitMage
     */
    @DataCheck
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(nickname = "逻辑删除", value = "逻辑删除", notes = "逻辑删除", httpMethod = "POST")
    public ResultPoJo logicDel(@RequestBody LongIdPo po) {
        return service.logicDel(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 新增或修改ApplicationVisitMage
     */
    @DataCheck
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(nickname = "新增或修改", value = "新增或修改", notes = "新增或修改", httpMethod = "POST")
    public ResultPoJo saveOrUpdate(@RequestBody ApplicationVisitMagePo po) {
        return service.saveOrUpdate(po);
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 查询详细信息ApplicationVisitMage
     */
    @DataCheck
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @ApiOperation(nickname = "查询详细信息", value = "查询详细信息", notes = "查询详细信息", httpMethod = "POST")
    public ResultPoJo<ApplicationVisitMageInfoVo> findInfo(@RequestBody LongIdPo po) {
        return service.findInfo(po);
    }
}