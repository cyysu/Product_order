package cn.jbit.product_order.dao;

import cn.jbit.product_order.entity.Orders;

public interface ordersDao {
	/**
	 * 创建订单
	 */
	public int save(Orders orders);
	/**
	 * 删除订单
	 */
	public void deleteById(int orderid);
	/**
	 * 根据编号查询订单
	 */
	public Orders getById(int orderid);
}
