package com.wisea.yysc.tp.system.service.system;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.yysc.common.dao.UserAgreementMageMapper;
import com.wisea.yysc.common.entity.UserAgreementMage;

import com.wisea.yysc.common.po.*;
import com.wisea.yysc.common.vo.UserAgreementMageGetVo;
import com.wisea.yysc.common.vo.UserAgreementMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserAgreementMageService
 * 用户协议 Service
 * 2021/02/04 10:50:41
 */
@Service
public class UserAgreementMageService extends BaseService {
    @Autowired
    protected UserAgreementMageMapper userAgreementMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<UserAgreementMageListVo>> findPage(UserAgreementMagePagePo userAgreementMagePagePo) {
        ResultPoJo<Page<UserAgreementMageListVo>> result = new ResultPoJo<>();
        Page<UserAgreementMageListVo> page = userAgreementMagePagePo.getPage();
        List<UserAgreementMageListVo> list = userAgreementMageMapper.findPage(userAgreementMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<UserAgreementMageListVo>> findList(UserAgreementMageListPo userAgreementMageListPo) {
        ResultPoJo<List<UserAgreementMageListVo>> result = new ResultPoJo<>();
        result.setResult(userAgreementMageMapper.findList(userAgreementMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<UserAgreementMageGetVo> get(UserAgreementMageGetPo userAgreementMageGetPo) {
        ResultPoJo<UserAgreementMageGetVo> result = new ResultPoJo<>();
        UserAgreementMage entity = userAgreementMageMapper.selectByPrimaryKey(userAgreementMageGetPo.getId());
        UserAgreementMageGetVo vo = new UserAgreementMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(UserAgreementMageInsertPo userAgreementMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        UserAgreementMage userAgreementMage = new UserAgreementMage();
        ConverterUtil.copyProperties(userAgreementMageInsertPo, userAgreementMage);
        userAgreementMage.preInsert();
        userAgreementMageMapper.insert(userAgreementMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(UserAgreementMageUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        UserAgreementMage userAgreementMage = new UserAgreementMage();
        if(ConverterUtil.isNotEmpty(po.getId())){
            ConverterUtil.copyProperties(po, userAgreementMage);
            userAgreementMage.preUpdate();
            userAgreementMageMapper.updateByPrimaryKeySelective(userAgreementMage);
        }else{
            ConverterUtil.copyProperties(po, userAgreementMage);
            userAgreementMage.preInsert();
            userAgreementMageMapper.insertSelective(userAgreementMage);
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(UserAgreementMageBatDeletePo userAgreementMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : userAgreementMageBatDeletePo.getDelList()) {
            UserAgreementMage userAgreementMage = new UserAgreementMage();
            userAgreementMage.setId(delId);
            userAgreementMage.preUpdate();
            userAgreementMageMapper.deleteLogic(userAgreementMage);
        }
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<UserAgreementMageGetVo> findInfo() {
        ResultPoJo<UserAgreementMageGetVo> result = new ResultPoJo<>();
        UserAgreementMageGetVo vo = userAgreementMageMapper.findInfo();
        result.setResult(vo);
        return result;
    }
}