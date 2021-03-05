package com.wisea.yysc.tp.system.service.system;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.yysc.common.dao.OrderInfosMapper;
import com.wisea.yysc.common.po.MembRankPageListPo;
import com.wisea.yysc.common.vo.MembRankPageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembRankService extends BaseService {
    @Autowired
    private OrderInfosMapper orderInfoMapper;
    /**
     * 分页查询会员排行列表信息
     * @param po
     * @return
     */
    public ResultPoJo<Page<MembRankPageListVo>> findPage(MembRankPageListPo po) {
        ResultPoJo<Page<MembRankPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<MembRankPageListVo> page = po.getPage();
        po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));// 开始时间
        po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));// 结束时间
        List<MembRankPageListVo> list = orderInfoMapper.findMembRankList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 导出会员排行列表信息
     * @param po
     * @return
     */
    public  List<MembRankPageListVo> findListExport(MembRankPageListPo po) {
        po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));// 开始时间
        po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));// 结束时间
        return orderInfoMapper.findMembRankList(po);
    }

}
