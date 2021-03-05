//package com.wisea.yysc.tp.system.controller.system;
//
//import com.wisea.cloud.common.annotation.DataCheck;
//import com.wisea.cloud.common.pojo.ResultPoJo;
//import com.wisea.cloud.common.sys.entity.User;
//import com.wisea.cloud.model.Page;
//import com.wisea.yysc.common.po.FreezeMembUpdPo;
//import com.wisea.yysc.common.po.MembInfoPagePo;
//import com.wisea.yysc.common.po.memb.*;
//import com.wisea.yysc.common.vo.MembInfoListVo;
//import com.wisea.yysc.common.vo.memb.MembInfoFindVo;
//import com.wisea.yysc.tp.system.service.system.MembInfoService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
///**
// * 成员设置相关的接口
// */
//@Api(tags = "应用市场信息相关接口")
//@RequestMapping(value = "/w/admin")
//@RestController
//public class MembInfoController {
//
//   @Autowired
//   private MembInfoService membInfoService;
//
//    @ApiOperation(value = "获取会员信息分页列表")
//    @PostMapping(value = "/findPage")
//    @DataCheck
//    public ResultPoJo<Page<MembInfoListVo>> findPage(@RequestBody MembInfoPagePo membInfoPagePo) {
//        return membInfoService.findPage(membInfoPagePo);
//    }
//
//
//    /**
//     * 是否启用
//     *
//     */
//    @ApiOperation("是否启用")
//    @PostMapping(value="/frozen")
//    @DataCheck
//    public ResultPoJo<String> membBatFrozen(@RequestBody FreezeMembUpdPo po){
//        // 返回参数
//        return membInfoService.freezeMemb(po);
//    }
//
//    @ApiOperation(value = "查询会员信息")
//    @RequestMapping(value = "/get", method = RequestMethod.POST)
//    @DataCheck
//    public ResultPoJo<MembInfoFindVo> get(@RequestBody MembInfoFindPo membInfoFindPo) {
//        return membInfoService.get(membInfoFindPo);
//    }
//
//    /**
//     * 添加会员的接口
//     *
//     * @author wangh(wisea)
//     *
//     * @date 2020年6月11日
//     * @version 1.0
//     */
//    @ApiOperation(value = "添加会员的接口")
//    @PostMapping(value = { "/addUserMemb" })
//    @DataCheck
//    public ResultPoJo<User> addUserMemb(@RequestBody RegisterMembPo po){
//        // 处理并且返回
//        return membInfoService.addUserMemb(po);
//    }
//
//    /**
//     * 删除
//     * @param po
//     * @return
//     */
//    @ApiOperation(value = "删除用户")
//    @PostMapping(value = "/del")
//    @DataCheck
//    public ResultPoJo<Object> batDelete(@RequestBody MembInfoDelPo po) {
//        return membInfoService.batDelete(po);
//    }
//
//
//}
