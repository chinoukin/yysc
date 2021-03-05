package com.wisea.yysc.common.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.yysc.common.dao.OrderInfosMapper;

import java.util.List;

/**
 * Auth： yangtao
 * remark:
 */
public class FindMaxNumUtils {

    private static OrderInfosMapper orderInfosMapper = SpringBootContext.getBean(OrderInfosMapper.class);

    /**
     * 查询订单最大编号
     *
     * @param parameter
     * @return
     */
    public static List<String> findOrderMaxNum(String parameter) {

        List<String> list = orderInfosMapper.findOrderNum(parameter);

        return list;
    }

}
