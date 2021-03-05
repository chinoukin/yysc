package com.wisea.yysc.tp.system.service.system;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.yysc.common.dao.CollAcctMageMapper;
import com.wisea.yysc.common.dao.YspayBanksMapper;
import com.wisea.yysc.common.entity.CollAcctMage;
import com.wisea.yysc.common.entity.YspayBanks;
import com.wisea.yysc.common.po.*;
import com.wisea.yysc.common.vo.CollAcctMageGetVo;
import com.wisea.yysc.common.vo.CollAcctMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CollAcctMageService
 * 收款账号设置 Service
 * 2021/02/04 10:50:41
 */
@Service
public class CollAcctMageService extends BaseService {
    @Autowired
    private CollAcctMageMapper collAcctMageMapper;
    @Autowired
    private YspayBanksMapper banksMapper;
    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<CollAcctMageListVo>> findPage(CollAcctMagePagePo collAcctMagePagePo) {
        ResultPoJo<Page<CollAcctMageListVo>> result = new ResultPoJo<>();
        Page<CollAcctMageListVo> page = collAcctMagePagePo.getPage();
        List<CollAcctMageListVo> list = collAcctMageMapper.findPage(collAcctMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<CollAcctMageListVo>> findList(CollAcctMageListPo collAcctMageListPo) {
        ResultPoJo<List<CollAcctMageListVo>> result = new ResultPoJo<>();
        result.setResult(collAcctMageMapper.findList(collAcctMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<CollAcctMageGetVo> get(CollAcctMageGetPo collAcctMageGetPo) {
        ResultPoJo<CollAcctMageGetVo> result = new ResultPoJo<>();
        CollAcctMage entity = collAcctMageMapper.selectByPrimaryKey(collAcctMageGetPo.getId());
        CollAcctMageGetVo vo = new CollAcctMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(CollAcctMageInsertPo collAcctMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CollAcctMage collAcctMage = new CollAcctMage();
        ConverterUtil.copyProperties(collAcctMageInsertPo, collAcctMage);
        collAcctMage.preInsert();
        collAcctMageMapper.insert(collAcctMage);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(CollAcctMageUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        CollAcctMage collAcctMage = new CollAcctMage();
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        if(ConverterUtil.isNotEmpty(po.getId())){
            ConverterUtil.copyProperties(po, collAcctMage);
            collAcctMage.preUpdate();
            collAcctMageMapper.updateByPrimaryKeySelective(collAcctMage);
        }else{
            ConverterUtil.copyProperties(po, collAcctMage);
            collAcctMage.preInsert();
            collAcctMageMapper.insertSelective(collAcctMage);
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(CollAcctMageBatDeletePo collAcctMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : collAcctMageBatDeletePo.getDelList()) {
            CollAcctMage collAcctMage = new CollAcctMage();
            collAcctMage.setId(delId);
            collAcctMage.preUpdate();
            collAcctMageMapper.deleteLogic(collAcctMage);
        }
        return result;
    }

    /**
     * 查询
     * @return
     */
    public ResultPoJo<CollAcctMageGetVo> findInfo() {
        ResultPoJo<CollAcctMageGetVo> result = new ResultPoJo<>();
        CollAcctMageGetVo vo = collAcctMageMapper.findInfo();
        result.setResult(vo);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2020/6/1 9:42
     * @Description 查询银行行别或查询银行支行列表
     */
    public ResultPoJo<List<YspayBanks>> findBanks(YspayBanks banks){
        ResultPoJo<List<YspayBanks>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<YspayBanks> list = banksMapper.findList(banks);
        resultPoJo.setResult(list);
        return resultPoJo;
    }
}