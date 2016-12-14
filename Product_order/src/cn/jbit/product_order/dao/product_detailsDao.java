package cn.jbit.product_order.dao;

import cn.jbit.product_order.entity.OrdersDetails;

public interface product_detailsDao {
	/**
	 * 新增订单
	 */
	public int save(OrdersDetails orderdetails);
	/**
	 * 根据编号删除订单明细信息
	 */
	public int deleteById(int orderdeid);
	/**
	 * 根据编号查找订单明细信息
	 */
	public OrdersDetails getById(int ordeId);
}
