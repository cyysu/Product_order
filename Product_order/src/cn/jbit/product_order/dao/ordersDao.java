package cn.jbit.product_order.dao;

import cn.jbit.product_order.entity.Orders;

public interface ordersDao {
	/**
	 * ��������
	 */
	public int save(Orders orders);
	/**
	 * ɾ������
	 */
	public void deleteById(int orderid);
	/**
	 * ���ݱ�Ų�ѯ����
	 */
	public Orders getById(int orderid);
}
