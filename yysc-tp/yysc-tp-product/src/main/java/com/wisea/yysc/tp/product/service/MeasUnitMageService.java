package com.wisea.yysc.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.constants.ConstantCodeMsg;
import com.wisea.yysc.common.dao.LevelSpecQuoteMapper;
import com.wisea.yysc.common.dao.MeasUnitMageMapper;
import com.wisea.yysc.common.entity.MeasUnitMage;
import com.wisea.yysc.common.po.product.MeasUnitMagePageListPo;
import com.wisea.yysc.common.po.product.MeasUnitMagePo;
import com.wisea.yysc.common.vo.product.LevelSpecQuoteInfoVo;
import com.wisea.yysc.common.vo.product.MeasUnitMageInfoVo;
import com.wisea.yysc.common.vo.product.MeasUnitMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MeasUnitMageService
 * @date 2021/01/29 10:42:38
 * @Description 
 */
@Service
public class MeasUnitMageService extends BaseService {
    @Autowired
    private MeasUnitMageMapper mapper;
	@Autowired
	private LevelSpecQuoteMapper levelSpecQuoteMapper;

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 10:42:38
     * @Description 分页查询MeasUnitMage
     */
    public ResultPoJo<Page<MeasUnitMagePageListVo>> findPageList(MeasUnitMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<MeasUnitMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<MeasUnitMagePageListVo> page = po.getPage();
		List<MeasUnitMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 10:42:38
     * @Description 逻辑删除MeasUnitMage
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//删除之前查看是否有商品引用这个计量单位
		if (beforeChangeCheck(po.getId(), resultPoJo)) return resultPoJo;
		MeasUnitMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(MeasUnitMage.DEL_FLAG_DELETE);
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
     * @date 2021/01/29 10:42:38
     * @Description 新增或修改MeasUnitMage
     */
    public ResultPoJo saveOrUpdate(MeasUnitMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改之前查看是否有商品引用这个计量单位
			if (beforeChangeCheck(po.getId(), resultPoJo)) return resultPoJo;
			//修改
			MeasUnitMage entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//查看编号和名称是否相同
			if (po.getUnitNum().equals(po.getMeasUnitName())) {
				resultPoJo.setCode(ConstantCodeMsg.ERR_313);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_313);
				return resultPoJo;
			}
			//新增
			MeasUnitMage entity = new MeasUnitMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

	private boolean beforeChangeCheck(Long id, ResultPoJo resultPoJo) {
		//修改之前查看是否有商品引用这个计量单位
		List<LevelSpecQuoteInfoVo> commCiteMeasUnit = levelSpecQuoteMapper.beforeDelSelectMeas(id);
		if (commCiteMeasUnit.size() > 0) {
			resultPoJo.setCode(ConstantCodeMsg.ERR_312);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_312);
			return true;
		}
		return false;
	}

	/**
     * @author wbf-code-generator
     * @date 2021/01/29 10:42:38
     * @Description 查询详细信息MeasUnitMage
     */
    public ResultPoJo<MeasUnitMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<MeasUnitMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MeasUnitMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}