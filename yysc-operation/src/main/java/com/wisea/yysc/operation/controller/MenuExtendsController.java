package com.wisea.yysc.operation.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.yysc.common.po.memb.MenuExtendsUserInitPo;
import com.wisea.yysc.common.vo.memb.UpdUserMenuInitVo;
import com.wisea.yysc.operation.service.MenuExtendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 菜单扩展类接口Controller
 * 
 * @author wangh(wisea)
 *
 * @date 2020年6月24日
 * @version 1.0
 */
@Api(tags = "菜单扩展信息操作接口")
@RestController
@RequestMapping(value = "/w/admin/menu")
public class MenuExtendsController {

	@Autowired
	private MenuExtendsService menuExtendsService;
	
//	/**
//	 * 首页菜单的查询操作
//	 *
//	 * @author wangh(wisea)
//	 *
//	 * @date 2020年6月28日
//	 * @version 1.0
//	 */
//	@ApiOperation(value = "首页菜单的查询操作",notes = "首页菜单的查询操作")
//	@PostMapping(value = "/findMenuForIndex")
//	@DataCheck
//	public ResultPoJo<List<ViewMenuExtendsVo>> findMeunListForIndex(@RequestBody MenuExtendsPo po){
//		// 查询返回处理
//		return menuExtendsService.findMeunListForIndex(po);
//	}
	/**
	 * 新增修改用户时菜单的初期化处理
	 * 
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月28日
	 * @version 1.0
	 */
	@ApiOperation(value = "新增修改用户时菜单的初期化处理",notes = "新增修改用户时菜单的初期化处理")
	@PostMapping(value = "/updUserMenuInit")
	@DataCheck
	public ResultPoJo<List<UpdUserMenuInitVo>> updUserMenuInit(@RequestBody MenuExtendsUserInitPo po){
		// 查询并且返回
		return menuExtendsService.updUserMenuInit(po);
	}
}
