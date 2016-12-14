package cn.jbit.product_order.dao;

import java.util.List;

import cn.jbit.product_order.entity.Product;

public interface productDao {
	/**
	 * 查询所有商品信息 
	 */
	public List<Product> getAll();
	/**
	 * 根据编号查询商品信息
	 */
	public Product getById(int proid);
}
