package com.wisea.yysc.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import java.util.List;

import com.wisea.yysc.common.dao.CommAttriMageMapper;
import com.wisea.yysc.common.dao.CommAttriSetMapper;
import com.wisea.yysc.common.entity.CommAttriMage;
import com.wisea.yysc.common.po.product.CommAttriMagePageListPo;
import com.wisea.yysc.common.po.product.CommAttriMagePo;
import com.wisea.yysc.common.vo.product.CommAttriMageInfoVo;
import com.wisea.yysc.common.vo.product.CommAttriMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommAttriMageService
 * @date 2021/01/28 14:49:36
 * @Description 
 */
@Service
public class CommAttriMageService extends BaseService {
    @Autowired
    private CommAttriMageMapper mapper;
	@Autowired
	private CommAttriSetMapper commAttriSetMapper;

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 分页查询CommAttriMage
     */
    public ResultPoJo<Page<CommAttriMagePageListVo>> findPageList(CommAttriMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<CommAttriMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<CommAttriMagePageListVo> page = po.getPage();
		List<CommAttriMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 逻辑删除CommAttriMage
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommAttriMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(CommAttriMage.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
			commAttriSetMapper.updateByAttriId(po.getId());
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 新增或修改CommAttriMage
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(CommAttriMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			CommAttriMage entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			CommAttriMage entity = new CommAttriMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 14:49:36
     * @Description 查询详细信息CommAttriMage
     */
    public ResultPoJo<CommAttriMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<CommAttriMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommAttriMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}