package cn.jbit.product_order.dao;

import cn.jbit.product_order.entity.OrdersDetails;

public interface product_detailsDao {
	/**
	 * ��������
	 */
	public int save(OrdersDetails orderdetails);
	/**
	 * ���ݱ��ɾ��������ϸ��Ϣ
	 */
	public int deleteById(int orderdeid);
	/**
	 * ���ݱ�Ų��Ҷ�����ϸ��Ϣ
	 */
	public OrdersDetails getById(int ordeId);
}
