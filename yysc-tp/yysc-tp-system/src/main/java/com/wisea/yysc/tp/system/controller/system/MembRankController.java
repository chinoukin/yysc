package com.wisea.yysc.tp.system.controller.system;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.DateUtils;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.yysc.common.po.MembRankPageListPo;
import com.wisea.yysc.common.vo.AppMarketUserListVo;
import com.wisea.yysc.common.vo.MembRankPageListVo;
import com.wisea.yysc.tp.system.service.system.MembRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 会员排行
 *    wzx
 */
@Api(tags = "会员排行相关的接口")
@RestController
@RequestMapping(value="/w/membRank")
public class MembRankController {

    @Autowired
    private MembRankService membRankService;
    /**
     * 分页查询会员排行列表信息
     *
     */
    @ApiOperation("分页查询会员排行列表信息")
    @PostMapping(value = "/findPage")
    @DataCheck
    public ResultPoJo<Page<MembRankPageListVo>> findPage(@RequestBody MembRankPageListPo po){
        // 返回参数
        return membRankService.findPage(po);
    }

    /**
     * 导出会员排行列表信息
     *
     */
    @ApiOperation("导出会员排行列表信息")
    @PostMapping(value = "/export")
    @DataCheck
    public void membRankListExport(@RequestBody MembRankPageListPo po, HttpServletResponse response){
        //  返回参数
        try {
            String fileName = "导出会员排行列表信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("导出会员排行列表信息", AppMarketUserListVo.class).setDataList(membRankService.findListExport(po)).writeWithAjaxHeader(response, fileName).dispose();
        } catch (Exception e) {
            throw new RuntimeException("Excel导出失败："+e.getMessage(), e);
        }
    }

}
