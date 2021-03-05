package com.wisea.yysc.tp.system.service.web;

import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.yysc.common.dao.MembInfoMapper;
import com.wisea.yysc.common.entity.MembInfo;

import com.wisea.yysc.common.po.memb.MembInfoGetPo;
import com.wisea.yysc.common.po.memb.MembInfoUpdatePo;
import com.wisea.yysc.common.vo.memb.MembInfoGetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * MembInfoService
 * 会员信息 Service
 * 2021/01/26 16:30:07
 */
@Service
public class MembInfoBasicService extends BaseService {
    @Autowired
    protected MembInfoMapper membInfoMapper;

    @Autowired
    private RemoteUserMss remoteUserMss;


    /**
     * 查询
     */
    public ResultPoJo<MembInfoGetVo> get(MembInfoGetPo membInfoGetPo) {
        ResultPoJo<MembInfoGetVo> result = new ResultPoJo<>();
        MembInfo entity = membInfoMapper.selectByPrimaryKey(membInfoGetPo.getId());
        MembInfoGetVo vo = new MembInfoGetVo();
        if (ConverterUtil.isNotEmpty(entity)){
            ConverterUtil.copyProperties(entity, vo);
        }
        result.setResult(vo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(MembInfoUpdatePo membInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        MembInfo membInfo = new MembInfo();
        ConverterUtil.copyProperties(membInfoUpdatePo, membInfo);
        membInfo.preUpdate();
        membInfoMapper.updateByPrimaryKeySelective(membInfo);
        return result;
    }



}