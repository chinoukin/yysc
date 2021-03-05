package com.wisea.yysc.tp.system.controller.system;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;

import com.wisea.yysc.common.po.AppMarketUserPagePo;
import com.wisea.yysc.common.po.FindMembInfoPo;
import com.wisea.yysc.common.po.FreezeMembUpdPo;
import com.wisea.yysc.common.po.memb.MembMobileUpdPo;
import com.wisea.yysc.common.po.memb.SubAcctInfoGetPo;
import com.wisea.yysc.common.vo.AppMarketUserListVo;
import com.wisea.yysc.common.vo.FindMembInfoVo;
import com.wisea.yysc.tp.system.service.system.AppMarketUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 应用市场用户管理
 *    wzx
 */
@Api(tags = "应用市场用户管理相关接口")
@RestController
@RequestMapping(value="/w/marketUser")
public class AppMarketUserController {

    @Autowired
    private AppMarketUserService appMarketUserService;

     /**
 	 * 分页查询应用市场用户列表信息
     *
 	 */
	@ApiOperation("分页查询应用市场用户列表信息")
	@PostMapping(value = "/findPage")
	@DataCheck
	public ResultPoJo<Page<AppMarketUserListVo>> findPage(@RequestBody AppMarketUserPagePo po){
		// 返回参数
		return appMarketUserService.findPage(po);
	}

	/**
	 * 导出应用市场用户列表信息
	 *
	 */
	@ApiOperation("导出应用市场用户列表信息")
	@PostMapping(value = "/export")
	@DataCheck
	public void marketUserListExport(@RequestBody AppMarketUserPagePo po, HttpServletResponse response){
		//  返回参数
		try {
			String fileName = "应用市场用户列表信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
			new ExportExcel("应用市场用户列表信息", AppMarketUserListVo.class).setDataList(appMarketUserService.findListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
		} catch (Exception e) {
			throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
		}
	}

	/**
	 * 冻结/解冻
	 *
	 */
	@ApiOperation("冻结/解冻")
	@PostMapping(value="/frozen")
	@DataCheck
	public ResultPoJo<String> membBatFrozen(@RequestBody FreezeMembUpdPo po){
		// 返回参数
		return appMarketUserService.freezeMemb(po);
	}

	/**
	 * 注册手机号的修改
	 *
	 */
	@ApiOperation("注册手机号的修改")
	@PostMapping(value = "/updMobile")
	@DataCheck
	public ResultPoJo<String> updMembMobile(@RequestBody MembMobileUpdPo membMobileUpdPo){
		// 返回参数
		return appMarketUserService.updMembMobile(membMobileUpdPo);
	}

	/**
	 * 删除用户
	 *
	 */
	@ApiOperation("删除用户")
	@PostMapping(value = "/del")
	@DataCheck
	public ResultPoJo<String> delMembSub(@RequestBody SubAcctInfoGetPo subAcctInfoGetPo){
		// 返回参数
		return appMarketUserService.delMembSub(subAcctInfoGetPo);
	}



	/**
	 * 查看详情会员信息
	 *
	 */
	@ApiOperation("查看详情会员信息")
	@PostMapping(value = "/findInfo")
	@DataCheck
	public ResultPoJo<FindMembInfoVo> findInfo(@RequestBody FindMembInfoPo po){
		// 返回处理
		return appMarketUserService.findInfo(po);
	}
}
