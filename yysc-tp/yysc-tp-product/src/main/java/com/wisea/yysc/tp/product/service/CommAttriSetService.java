package com.wisea.yysc.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.dao.CommAttriMageMapper;
import com.wisea.yysc.common.dao.CommAttriSetMapper;
import com.wisea.yysc.common.entity.CommAttriSet;
import com.wisea.yysc.common.po.product.CommAttriSetPageListPo;
import com.wisea.yysc.common.po.product.CommAttriSetPo;
import com.wisea.yysc.common.po.product.CommTree;
import com.wisea.yysc.common.vo.product.CommAttriSetInfoVo;
import com.wisea.yysc.common.vo.product.CommAttriSetPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommAttriSetService
 * @date 2021/01/28 15:49:59
 * @Description 
 */
@Service
public class CommAttriSetService extends BaseService {
    @Autowired
    private CommAttriSetMapper mapper;
	@Autowired
	private CommAttriMageMapper commAttriMageMapper;

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 15:49:59
     * @Description 分页查询CommAttriSet
     */
    public ResultPoJo<Page<CommAttriSetPageListVo>> findPageList(CommAttriSetPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<CommAttriSetPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<CommAttriSetPageListVo> page = po.getPage();
		List<CommAttriSetPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 15:49:59
     * @Description 逻辑删除CommAttriSet
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommAttriSet entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(CommAttriSet.DEL_FLAG_DELETE);
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
     * @date 2021/01/28 15:49:59
     * @Description 新增或修改CommAttriSet
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(CommAttriSetPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			CommAttriSet entity = mapper.selectByPrimaryKey(po.getId());
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
			CommAttriSet entity = new CommAttriSet();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/28 15:49:59
     * @Description 查询详细信息CommAttriSet
     */
    public ResultPoJo<CommAttriSetInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<CommAttriSetInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommAttriSetInfoVo commAttriSetGetVo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(commAttriSetGetVo)){
			resultPoJo.setResult(commAttriSetGetVo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}

		StringBuffer buffer = new StringBuffer();
		List<CommTree> commMageGetVos = commAttriMageMapper.beforeInsertGetCatgList();
		// 转化为树结构
		List<CommTree> commMageGetVoTree =
				TreeUtils.listToTree(commMageGetVos);
		// 处理商品树传给前端一个字符串
		for (CommTree tree : commMageGetVoTree) {
			if (tree.getId().equals(commAttriSetGetVo.getCommId())) {
				buffer.append(tree.getId() + ",");
				commAttriSetGetVo.setCommodity(buffer.toString());
				resultPoJo.setResult(commAttriSetGetVo);
				return resultPoJo;
			}
			for (CommTree tree2 : tree.getChildren()) {
				if (tree2.getId().equals(commAttriSetGetVo.getCommId())) {
					buffer.append(tree.getId() + "," + tree2.getId() + ",");
				}
				for (CommTree tree3 : tree2.getChildren()) {
					if (tree3.getId().equals(commAttriSetGetVo.getCommId())) {
						buffer.append(tree.getId() + "," + tree3.getParentId() + "," + tree3.getId() + ",");
					}
				}
			}
		}

		commAttriSetGetVo.setCommodity(buffer.toString());
		resultPoJo.setResult(commAttriSetGetVo);
		return resultPoJo;
    }
}