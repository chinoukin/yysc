package com.wisea.yysc.tp.product.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;

import com.wisea.cloud.model.po.LongIdPo;

import com.wisea.yysc.common.entity.CommMage;


import com.wisea.yysc.common.po.product.CommMageInsertPo;
import com.wisea.yysc.common.po.product.CommMageTreePo;
import com.wisea.yysc.common.vo.CommMageListVo;
import com.wisea.yysc.common.vo.product.CommMageTreeVo;
import com.wisea.yysc.tp.product.service.CommMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className 分类管理
 * @date 2021/01/28 09:48:08
 * @Description 
 */
@Api(tags = "后台--基础分类管理")
@RestController
@RequestMapping("/w/CommMage")
public class CommMageController {
    @Autowired
    private CommMageService commMageService;

    /**
     * 查询基础品类树
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询基础品类树", value = "查询基础品类树", notes = "查询基础品类树")
    @RequestMapping(value = "/findCommMageTree", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CommMageTreeVo>> findCommMageTree(@RequestBody CommMageTreePo po) {
        return commMageService.findCommMageTree(po);
    }

    /**
     * 添加和修改基础分类信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "添加和修改基础分类", value = "添加和修改基础分类信息", notes = "添加和修改基础分类信息")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdate(@RequestBody CommMageInsertPo po) {
        return commMageService.saveOrUpdate(po);
    }

    /**
     * 查询基础分类详细信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询基础分类详细信息", value = "查询基础分类详细信息", notes = "查询基础分类详细信息")
    @RequestMapping(value = "/findCommMageInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CommMageListVo> findCommMageInfo(@RequestBody LongIdPo po) {
        return commMageService.findCommMageInfo(po);
    }

    /**
     * 删除基础分类
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "删除基础分类", value = "删除基础分类", notes = "删除基础分类")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> del(@RequestBody LongIdPo po) {
        return commMageService.del(po);
    }

}