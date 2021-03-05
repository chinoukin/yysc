package com.wisea.yysc.tp.system.controller.system;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.yysc.common.po.*;
import com.wisea.yysc.common.vo.UserAgreementMageGetVo;
import com.wisea.yysc.tp.system.service.system.UserAgreementMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * UserAgreementMageController
 * 用户协议 Controller
 * 2021/02/04 10:50:41
 */
@Api(tags = "用户协议相关接口")
@RequestMapping(value = "/w/agreement")
@RestController
public class UserAgreementMageController {
    @Autowired
    protected UserAgreementMageService userAgreementMageService;

    @ApiOperation(value = "查询用户协议详情")
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<UserAgreementMageGetVo> findInfo() {
        return userAgreementMageService.findInfo();
    }

    @ApiOperation(value = "新增修改用户协议")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody UserAgreementMageUpdatePo userAgreementMageUpdatePo) {
        return userAgreementMageService.update(userAgreementMageUpdatePo);
    }

    @ApiOperation(value = "批量删除用户协议")
    @RequestMapping(value = "/batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody UserAgreementMageBatDeletePo userAgreementMageBatDeletePo) {
        return userAgreementMageService.batDelete(userAgreementMageBatDeletePo);
    }
}