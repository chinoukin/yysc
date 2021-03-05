package com.wisea.yysc.common.utils;

/**
 *
 * redis缓存key和分布式锁key
 * @author yangtao
 *
 */
public class RedisKeyConstants {

	/********************缓存key**********************/
	public static final String ORDER_CODE_FIX = "ORDER_CODE_FIX"; //订单编号key前缀（规则为前缀加12位随机数，没有过期时间）
	public static final String SETTLE_BILL_CODE_FIX = "SETTLE_BILL_CODE_FIX"; //结算单编号key前缀（规则为前缀加12位随机数，没有过期时间）
    // 商品单号key前缀
    public static final String COMM_PUB_INFO_FIX = "COMM_PUB_INFO_FIX";


	/************************分布式锁***********************/
	public static final String REFUND_CODE_LOCK = "REFUND_CODE_LOCK"; //退货、退货退款编号锁key
	public static final String ORDER_CODE_LOCK = "ORDER_CODE_LOCK"; //订单编号锁key
	public static final String SETTLE_BILL_CODE_LOCK = "SETTLE_BILL_CODE_LOCK"; //结算单编号锁key
    public static final String COMM_PUB_INFO_LOCK = "COMM_PUB_INFO_LOCK"; //商品单号key前缀
    public static final String ORDER_INVO_APPL_LOCK = "ORDER_INVO_APPL_LOCK";//订单发票申请开票服务单号锁key
    public static final String SETTLE_ORDER_INVO_APPL_LOCK = "SETTLE_ORDER_INVO_APPL_LOCK";//结算单发票申请开票服务单号锁key
}
