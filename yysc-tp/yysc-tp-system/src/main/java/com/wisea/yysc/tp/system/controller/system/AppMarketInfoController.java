package com.wisea.yysc.tp.system.controller.system;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.AppMarketInfoUpdatePo;
import com.wisea.yysc.common.vo.AppMarketInfoVo;
import com.wisea.yysc.tp.system.service.system.AppMarketInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * AppMarketInfoController
 * 应用市场信息 Controller
 * 2021/01/26 16:30:07
 */
@Api(tags = "应用市场信息相关接口")
@RequestMapping(value = "/w/appMarket")
@RestController
public class AppMarketInfoController {
    @Autowired
    private AppMarketInfoService appMarketInfoService;

    /**
     * 查询应用市场信息设置
     * @return
     */
    @DataCheck
    @PostMapping(value = "/findInfo")
    @ApiOperation("查询应用市场信息设置")
    public ResultPoJo<AppMarketInfoVo> findInfo() {
        return appMarketInfoService.findInfo();
    }

    @ApiOperation(value = "添加修改应用市场信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody AppMarketInfoUpdatePo appMarketInfoUpdatePo) {
        return appMarketInfoService.update(appMarketInfoUpdatePo);
    }
}