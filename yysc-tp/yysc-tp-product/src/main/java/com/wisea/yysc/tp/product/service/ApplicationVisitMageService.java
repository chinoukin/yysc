package com.wisea.yysc.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.dao.ApplicationVisitMageMapper;
import com.wisea.yysc.common.entity.ApplicationVisitMage;
import com.wisea.yysc.common.po.product.ApplicationVisitMagePageListPo;
import com.wisea.yysc.common.po.product.ApplicationVisitMagePo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMageInfoVo;
import com.wisea.yysc.common.vo.product.ApplicationVisitMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ApplicationVisitMageService
 * @date 2021/01/28 17:17:49
 * @Description 
 */
@Service
public class ApplicationVisitMageService extends BaseService {
    @Autowired
    private ApplicationVisitMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 分页查询ApplicationVisitMage
     */
    public ResultPoJo<Page<ApplicationVisitMagePageListVo>> findPageList(ApplicationVisitMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<ApplicationVisitMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ApplicationVisitMagePageListVo> page = po.getPage();
		List<ApplicationVisitMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 逻辑删除ApplicationVisitMage
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ApplicationVisitMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ApplicationVisitMage.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 新增或修改ApplicationVisitMage
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(ApplicationVisitMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ApplicationVisitMageInfoVo vo = mapper.findUnitNum(po.getUnitNum());
		if (ConverterUtil.isNotEmpty(vo)){
		   	 resultPoJo.setMsg("编码已被使用");
			return resultPoJo;
		}
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ApplicationVisitMage entity = mapper.selectByPrimaryKey(po.getId());
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
			ApplicationVisitMage entity = new ApplicationVisitMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 17:17:49
     * @Description 查询详细信息ApplicationVisitMage
     */
    public ResultPoJo<ApplicationVisitMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ApplicationVisitMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ApplicationVisitMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}