package com.wisea.yysc.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.yysc.common.dao.*;
import com.wisea.yysc.common.entity.*;
import com.wisea.yysc.common.po.product.CommPubInfoBatchDelPo;
import com.wisea.yysc.common.po.product.CommPubInfoPageListPo;
import com.wisea.yysc.common.po.product.CommPubInfoPo;
import com.wisea.yysc.common.po.product.MeasUnitMagePageListPo;
import com.wisea.yysc.common.vo.ApplicationVisitMageListVo;
import com.wisea.yysc.common.vo.CommAttriMageListVo;
import com.wisea.yysc.common.vo.product.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommPubInfoService
 * @date 2021/01/29 14:48:32
 * @Description 
 */
@Service
public class CommPubInfoService extends BaseService {
    @Autowired
    private CommPubInfoMapper mapper;
	@Autowired
	private CommMageMapper commMageMapper;
	@Autowired
	private CommAttriMapper commAttriMapper;
	@Autowired
	private LevelSpecQuoteMapper levelSpecQuoteMapper;
	@Autowired
	private CommPictureMapper commPictureMapper;
	@Autowired
	private MeasUnitMageMapper measUnitMageMapper;
	@Autowired
	private AppMarketInfoMapper appMarketInfoMapper;

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 分页查询CommPubInfo
     */
    public ResultPoJo<Page<CommPubInfoPageListVo>> findPageList(CommPubInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<CommPubInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<CommPubInfoPageListVo> page = po.getPage();
		List<CommPubInfoPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 逻辑删除CommPubInfo
     */
	@Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity) && !entity.getCommStateType().equals("0")){
			entity.setDelFlag(CommPubInfo.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_005);
			resultPoJo.setMsg("数据错误，操作对象不存在或数据的状态不符合");
		}
		return resultPoJo;
    }



    /**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 新增或修改CommPubInfo
     */
	@Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(CommPubInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			CommPubInfo entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)&& !entity.getCommStateType().equals("0")){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
				//先删除相关再重新新增
				commAttriMapper.deleteByCommPubId(entity.getId());
				levelSpecQuoteMapper.deleteByCommPubId(entity.getId());
				commPictureMapper.deleteByCommPubId(entity.getId());
				//重新新增
				commPubInfoInsert(po, entity.getId());
			}else{
				resultPoJo.setCode(ConstantError.ERR_005);
				resultPoJo.setMsg("数据错误，操作对象不存在或数据的状态不符合");
			}
		}else{
			//新增商品发布
			CommPubInfo entity = new CommPubInfo();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			entity.setLoginType(ConverterUtil.getUUID());
			entity.setMembId(SystemUtils.getUser().getId());
			mapper.insertSelective(entity);
			commPubInfoInsert(po, entity.getId());
		}
		return resultPoJo;
    }

	private void commPubInfoInsert(CommPubInfoPo po, Long id) {
		if (po.getCommAttriListPos()!=null) {
			//新增商品属性
			List<CommAttri> commAttris = new ArrayList<>();
			po.getCommAttriListPos().stream().forEach(p->{
				CommAttri commAttri = new CommAttri();
				BeanUtils.copyProperties(p, commAttri,"id");
				commAttri.preInsert();
				commAttri.setCommPubId(id);
				commAttris.add(commAttri);
			});
			commAttriMapper.batchInsert(commAttris);
		}

		if (po.getLevelSpecQuoteListPos()!=null) {
			//新增售卖规格
			ArrayList<LevelSpecQuote> levelSpecQuotes = new ArrayList<>();
			po.getLevelSpecQuoteListPos().stream().forEach(p->{
				LevelSpecQuote levelSpecQuote = new LevelSpecQuote();
				BeanUtils.copyProperties(p, levelSpecQuote,"id");
				levelSpecQuote.preInsert();
				levelSpecQuote.setCommPubId(id);
				levelSpecQuotes.add(levelSpecQuote);
			});
			levelSpecQuoteMapper.batchInsert(levelSpecQuotes);
		}

		if (po.getCommPictureListPos()!=null) {
			//新增相关图片
			ArrayList<CommPicture> commPictures = new ArrayList<>();
			po.getCommPictureListPos().stream().forEach(p->{
				CommPicture commPicture = new CommPicture();
				BeanUtils.copyProperties(p, commPicture,"id");
				commPicture.preInsert();
				commPicture.setCommPubId(id);
				commPictures.add(commPicture);
			});
			commPictureMapper.batchInsert(commPictures);
		}

	}


	/**
     * @author wbf-code-generator
     * @date 2021/01/29 14:48:32
     * @Description 查询详细信息CommPubInfo
     */
    public ResultPoJo<CommPubInfoInfoVo> findInfo(LongIdPo po, String i) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<CommPubInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommPubInfoInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			if (i.equals("0")) {
				CommMage pid = commMageMapper.findPid(vo.getCommId());
				List<CommPubInfoPageListVo> topThree = mapper.findTopThree(pid.getId());
				vo.setAppMarketInfo(appMarketInfoMapper.findAppMarketInfo());
				if (ConverterUtil.isNotEmpty(topThree)) {
					vo.setCommPubInfos(topThree);
				}
			}
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
	/**
	 * @author wbf-code-generator
	 * @date 2021/01/29 14:48:32
	 * @Description 上下架操作CommPubInfo
	 */
	@Transactional(readOnly = false)
	public ResultPoJo batchDel(CommPubInfoBatchDelPo po) {
		LoggerUtil.infoWithContext("【batchDel】上下架操作：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		List<String> ids = po.getIds();
		//查询是否符合上下架
		List<CommPubInfo> rest = mapper.batchSelect(ids, po.getState());
		if (rest.size() > 0) {
			resultPoJo.setCode(ConstantError.ERR_005);
			resultPoJo.setMsg("数据的状态不符合");
			return resultPoJo;
		}
		mapper.batchDel(ids,po.getState());
		return resultPoJo;
	}

	/**
	 * @author wbf-code-generator
	 * @date 2021/01/29 14:48:32
	 * @Description 新增应用前
	 */
	public ResultPoJo<NewApplicationsVo> newApplications(LongIdPo po) {
		LoggerUtil.infoWithContext("【NewApplications】新增应用前：", po);
		ResultPoJo<NewApplicationsVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		NewApplicationsVo newApplicationsVo = new NewApplicationsVo();
		CommMage pid = commMageMapper.findPid(po.getId());
		//如果是产业服务工具类型的则返回取商品配置-应用访问配置列表（应用编号+名称）信息
		if ("产业服务工具".equals(pid.getCommCatgName())) {
			List<ApplicationVisitMageListVo> names = mapper.findApplicationVisit();
			newApplicationsVo.setNames(names);
		}
		MeasUnitMagePageListPo measUnitMagePageList = new MeasUnitMagePageListPo();
		measUnitMagePageList.setEffeInvalState("0");
		measUnitMagePageList.setDimensionsType("1");
		newApplicationsVo.setMeasUnitMagePageListVosCount(measUnitMageMapper.findPageList(measUnitMagePageList));
		measUnitMagePageList.setDimensionsType("5");
		newApplicationsVo.setMeasUnitMagePageListVosTime(measUnitMageMapper.findPageList(measUnitMagePageList));
		//添加属性时所需属性
		List<CommAttriMageListVo> commAttriMageListVos = commMageMapper.findAttrByCommId(pid.getId());
		newApplicationsVo.setCommAttriMageListVos(commAttriMageListVos);
		resultPoJo.setResult(newApplicationsVo);
		return resultPoJo;
	}



	public ResultPoJo<List<WebPageListVo>> findWebPageList(CommPubInfoPageListPo po) {
		LoggerUtil.infoWithContext("【findWebPageList】分页查询列表",po);
		ResultPoJo<List<WebPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		List<WebPageListVo> webPageListVos = new ArrayList<>();
		List<CommPubInfoPageListVo> list = mapper.findWebPageList(po);
		Map<String, List<CommPubInfoPageListVo>> collect = list.stream().collect(Collectors.groupingBy(CommPubInfoPageListVo::getCommTitle));
		for(String key:collect.keySet()){
			WebPageListVo webPageListVo = new WebPageListVo();
			webPageListVo.setName(key);
			webPageListVo.setCommPubInfoPageListVoList(collect.get(key));
			webPageListVos.add(webPageListVo);
		}
		resultPoJo.setResult(webPageListVos);
		return resultPoJo;
	}
}