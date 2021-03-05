package com.wisea.yysc.tp.system.controller.system;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.entity.YspayBanks;
import com.wisea.yysc.common.po.*;
import com.wisea.yysc.common.vo.CollAcctMageGetVo;
import com.wisea.yysc.tp.system.service.system.CollAcctMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * CollAcctMageController
 * 收款账号设置 Controller
 * 2021/02/04 10:50:41
 */
@Api(tags = "收款账号设置相关接口")
@RequestMapping(value = "/w/collAcct")
@RestController
public class CollAcctMageController {
    @Autowired
    private CollAcctMageService collAcctMageService;

    @ApiOperation(value = "查询收款账号设置")
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CollAcctMageGetVo> findInfo() {
        return collAcctMageService.findInfo();
    }

    @ApiOperation(value = "新增修改收款账号设置")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody CollAcctMageUpdatePo collAcctMageUpdatePo) {
        return collAcctMageService.update(collAcctMageUpdatePo);
    }

    @ApiOperation(value = "批量删除收款账号设置")
    @RequestMapping(value = "/batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody CollAcctMageBatDeletePo collAcctMageBatDeletePo) {
        return collAcctMageService.batDelete(collAcctMageBatDeletePo);
    }

    /**
     * @Author jirg
     * @Date 2020/6/1 10:13
     * @Description 查询银行列表
     */
    @ApiOperation(value = "查询银行列表",notes = "查询银行列表")
    @PostMapping(value = "/findBanks")
    @DataCheck
    public ResultPoJo<List<YspayBanks>> findBanks(@RequestBody YspayBanks po){
        return collAcctMageService.findBanks(po);
    }
}