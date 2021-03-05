package com.wisea.yysc.tp.system.controller.web;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.memb.*;
import com.wisea.yysc.common.vo.memb.MembInfoGetVo;
import com.wisea.yysc.tp.system.service.web.MembInfoBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * MembInfoController
 * 会员信息 Controller
 * 2021/01/26 16:30:07
 */
@Api(tags = "基本信息相关接口")
@RequestMapping(value = "/w/basic")
@RestController
public class MembBasicInfoController {
    @Autowired
    protected MembInfoBasicService membInfoService;


    @ApiOperation(value = "查询会员信息")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<MembInfoGetVo> get(@RequestBody MembInfoGetPo membInfoGetPo) {
        return membInfoService.get(membInfoGetPo);
    }


    @ApiOperation(value = "修改会员信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody MembInfoUpdatePo membInfoUpdatePo) {
        return membInfoService.update(membInfoUpdatePo);
    }

}