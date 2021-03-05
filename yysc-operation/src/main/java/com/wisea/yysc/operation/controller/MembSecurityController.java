package com.wisea.yysc.operation.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.memb.MembPwdUpdatePo;
import com.wisea.yysc.common.po.memb.MobileUpdatePo;
import com.wisea.yysc.operation.service.MembInfoService;
import com.wisea.yysc.operation.service.MembSecurityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账号安全相关接口
 */
@Api(tags = "账号安全相关接口")
@RequestMapping(value = "/w/membSecur")
@RestController
public class MembSecurityController {
    @Autowired
    private MembSecurityService membSecurityService;
    /**
     * 修改登录密码(修改当前用户的密码)
     */
    @ApiOperation("【账号安全】修改登录密码(修改当前用户的密码)")
    @PostMapping(value = "/updPwd")
    @DataCheck
    public ResultPoJo<String> userUpdPwd(@RequestBody MembPwdUpdatePo membPwdUpdatePo){
        // 返回参数
        return membSecurityService.userUpdPwd(membPwdUpdatePo);
    }


    /**
     * 修改手机号
     */
    @DataCheck
    @PostMapping("/mobile/update")
    @ApiOperation(value = "【账号安全】修改手机号")
    public ResultPoJo<Object> updateMobile(@RequestBody MobileUpdatePo mobileUpdatePo) {
        return membSecurityService.updateMobile(mobileUpdatePo);
    }
}
