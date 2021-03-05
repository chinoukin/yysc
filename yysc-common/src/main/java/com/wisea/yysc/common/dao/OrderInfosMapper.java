package com.wisea.yysc.common.dao;

import com.wisea.cloud.common.interceptor.MapF2F;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.yysc.common.entity.OrderInfo;
import com.wisea.yysc.common.po.FindMembInfoPo;
import com.wisea.yysc.common.po.MembRankPageListPo;
import com.wisea.yysc.common.po.OrderInfoListPo;
import com.wisea.yysc.common.po.OrderInfoPagePo;
import com.wisea.yysc.common.po.memb.CheckValidPo;
import com.wisea.yysc.common.po.trade.BuyerOrderListPo;
import com.wisea.yysc.common.po.trade.OrdersInfoPo;
import com.wisea.yysc.common.po.trade.SellerOrderExpPo;
import com.wisea.yysc.common.po.trade.StaticOrderPo;
import com.wisea.yysc.common.vo.FindMembInfoPageVo;
import com.wisea.yysc.common.vo.MembRankPageListVo;
import com.wisea.yysc.common.vo.OrderInfoListVo;
import com.wisea.yysc.common.vo.memb.CheckValidVo;
import com.wisea.yysc.common.vo.trade.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * order_info 表DAO
 * 订单信息
 * 2021/01/26 16:30:07
 */
@Repository
public interface OrderInfosMapper extends CrudDao<OrderInfo> {


    /**
     * 查询超时代付款的订单
     * @return
     */
    List<OrderInfo> findPreOutTimeOrders();
    /**
     * 首页统计信息
     *
     * @param paramMap
     * @return
     */
    DayStatisticsVo dayStatistics(Map<String, Object> paramMap);

    /**
     * 查询代办事务
     *
     * @param paramMap
     * @return
     */
    OrderStatisticsVo orderStatistics(Map<String, Object> paramMap);

    /**
     * 查询订单最大编号
     *
     * @param ordNum
     * @return
     */
    List<String> findOrderNum(String ordNum);

    List<OrderInfoListVo> findPage(OrderInfoPagePo orderInfoPagePo);

    List<OrderInfoListVo> findList(OrderInfoListPo orderInfoListPo);

    /**
     * 查询订单状态
     *
     * @param buyerOrderListPo
     * @return
     */
    @MapF2F()
    Map<String, Integer> getOrderStateCountMap(BuyerOrderListPo buyerOrderListPo);

    /**
     * 查询订单列表
     *
     * @param buyerOrderListPo
     * @return
     */
    List<BuyerInfoListVo> findOrderList(BuyerOrderListPo buyerOrderListPo);

    /**
     * 查询应用列表
     *
     * @param po
     * @return
     */
    List<FindMembInfoPageVo> findAppList(FindMembInfoPo po);

    /**
     * 查询订单详情
     *
     * @param ordersInfoPo
     * @return
     */
    OrdersInfoVo findOrderInfo(OrdersInfoPo ordersInfoPo);

    /**
     * 分页查询会员排行列表信息
     *
     * @param po
     * @return
     */
    List<MembRankPageListVo> findMembRankList(MembRankPageListPo po);


    /**
     * 根据用户id 查询是否有试用订单
     *
     * @param membId
     * @return
     */
    List<OrdersInfoVo> selOrdertryList(Long membId);

    /**
     * 查询订单列表
     * @return
     */
    List<SellerOrderListVo> orderListExp (SellerOrderExpPo sellerOrderExpPo);

    /**
     * 财务 - 订单统计
     * @param po
     * @return
     */
    List<StatisOrderVo> statisOrder(StaticOrderPo po);

    /**
     * 首页统计信息
     *
     * @param paramMap
     * @return
     */
    MembStatisticVo membStatistics(Map<String, Object> paramMap);

    /**
     * 销售金额统计
     * @param paramMap
     * @return
     */
    OrderAmounStatisticsVo orderAmounStatistics(Map<String, Object> paramMap);

    /**
     * 订单数量统计
     * @param paramMap
     * @return
     */
    OrderCountStatisticsVo orderCountStatistics(Map<String, Object> paramMap);

    /**
     * 通过用户id和商品表示查询是否存在
     * @param checkValidPo
     * @return
     */
    CheckValidVo checkValid(CheckValidPo checkValidPo);
}