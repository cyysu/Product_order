package cn.jbit.product_order.dao;

import java.util.List;

import cn.jbit.product_order.entity.Product;

public interface productDao {
	/**
	 * ��ѯ������Ʒ��Ϣ 
	 */
	public List<Product> getAll();
	/**
	 * ���ݱ�Ų�ѯ��Ʒ��Ϣ
	 */
	public Product getById(int proid);
}
