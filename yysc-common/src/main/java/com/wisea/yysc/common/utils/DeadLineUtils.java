package com.wisea.yysc.common.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.yysc.common.dao.DeadLineMageMapper;
import com.wisea.yysc.common.entity.DeadLineMage;

/**
 * @author jirg
 * @version 1.0
 * @className DeadLineUtils
 * @date 2020/4/30 15:44
 * @Description 期限设置工具类
 */
public class DeadLineUtils {
    private static DeadLineMageMapper deadLineMageMapper = SpringBootContext.getBean(DeadLineMageMapper.class);
    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
    private static String DEAD_LINE_CACHE_KEY = "DEAD_LINE_MAGE";

    /**
     * @Author jirg
     * @Date 2020/4/30 15:59
     * @Description 根据类型查询期限值
     **/
    public static Integer getLimitDaysByType() {
        DeadLineMage serialize = jedisdao.getSerialize(DEAD_LINE_CACHE_KEY, DeadLineMage.class);
        if (ConverterUtil.isEmpty(serialize)) {
            DeadLineMage deadLineMage = deadLineMageMapper.getDeadLineMage();
            jedisdao.setSerialize(DEAD_LINE_CACHE_KEY, deadLineMage);
        }
        return serialize.getLimitDays();
    }

    /**
     * @Author jirg
     * @Date 2020/4/30 16:08
     * @Description 清除期限缓存
     **/
    public static void clearCache() {
        jedisdao.delSerialize(DEAD_LINE_CACHE_KEY);
    }
}
