package com.wisea.yysc.tp.trade.service;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.yysc.common.dao.DeadLineMageMapper;
import com.wisea.yysc.common.entity.DeadLineMage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单期限设置
 */
@Service
public class OrderDurationService extends BaseService {

    @Autowired
    private DeadLineMageMapper deadLineMageMapper;
    @Autowired
    private JedisDao jedisDao;

    // 订单期限缓存key
    public static final String DEAD_LINE_MAGE_KEY = "DEAD_LINE_MAGE";

    /**
     * 订单期限管理
     *
     * @return
     */
    public ResultPoJo<DeadLineMage> getDeadLineMage() {
        ResultPoJo<DeadLineMage> result = new ResultPoJo<DeadLineMage>(ConstantError.NOMAL);
        DeadLineMage deadLineMage = jedisDao.getSerialize(DEAD_LINE_MAGE_KEY, DeadLineMage.class);
        if (ConverterUtil.isEmpty(deadLineMage)) {
            deadLineMage = deadLineMageMapper.getDeadLineMage();
            if (ConverterUtil.isNotEmpty(deadLineMage)) {
                jedisDao.setSerialize(DEAD_LINE_MAGE_KEY, deadLineMage);
            }
        }
        result.setResult(deadLineMage);
        return result;
    }

    /**
     * 订单期限设置
     *
     * @param deadLineMage
     * @return
     */
    public ResultPoJo<?> saveOrUpdate(DeadLineMage deadLineMage) {
        ResultPoJo<DeadLineMage> result = new ResultPoJo<DeadLineMage>(ConstantError.NOMAL);
        DeadLineMage lateFeeMage = deadLineMageMapper.getDeadLineMage();
        if (ConverterUtil.isNotEmpty(lateFeeMage)) {

            deadLineMage.setDelFlag(DeadLineMage.DEL_FLAG_DELETE);
            deadLineMageMapper.updateByPrimaryKeySelective(deadLineMage);
        }
        deadLineMage.preInsert();
        deadLineMage.setDelFlag(DeadLineMage.DEL_FLAG_NORMAL);
        deadLineMageMapper.insert(deadLineMage);
        jedisDao.delSerialize(DEAD_LINE_MAGE_KEY);
        return result;
    }
}
