package com.wisea.yysc.tp.system.service.system;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.yysc.common.dao.AppMarketInfoMapper;
import com.wisea.yysc.common.entity.AppMarketInfo;
import com.wisea.yysc.common.po.AppMarketInfoUpdatePo;
import com.wisea.yysc.common.vo.AppMarketInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * AppMarketInfoService
 * 应用市场信息 Service
 * 2021/01/26 16:30:07
 */
@Service
public class AppMarketInfoService extends BaseService {

    @Autowired
    private AppMarketInfoMapper appMarketInfoMapper;

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(AppMarketInfoUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())){
            AppMarketInfo appMarketInfo = new AppMarketInfo();
            ConverterUtil.copyProperties(po, appMarketInfo);
            appMarketInfo.preUpdate();
            appMarketInfoMapper.updateByPrimaryKeySelective(appMarketInfo);
        }else{
            AppMarketInfo appMarketInfo = new AppMarketInfo();
            ConverterUtil.copyProperties(po, appMarketInfo);
            appMarketInfo.preInsert();
            appMarketInfoMapper.insertSelective(appMarketInfo);
        }

        return result;
    }

    /**
     * 查询应用市场信息设置
     * @return
     */
    public ResultPoJo<AppMarketInfoVo> findInfo() {
        ResultPoJo<AppMarketInfoVo> result = new ResultPoJo<>(ConstantError.NOMAL);
        AppMarketInfoVo vo = appMarketInfoMapper.findAppMarketInfo();
        result.setResult(vo);
        return result;
    }
}