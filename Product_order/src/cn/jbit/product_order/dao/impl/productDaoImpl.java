package cn.jbit.product_order.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.jbit.product_order.dao.hibernteUtil;
import cn.jbit.product_order.dao.productDao;
import cn.jbit.product_order.entity.Product;

public class productDaoImpl extends hibernteUtil implements productDao {

	@Override
	public List<Product> getAll() {
		Session session=null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("FROM Product");
			@SuppressWarnings("unchecked")
			List<Product> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@Override
	public Product getById(int proid) {
		Session session = null;
		Product pro = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("from Product as pro where pro.id = ?");
			query.setInteger(0, proid);
			/**
			 * 通过    uniqueResult  获取值
			 */
			pro =(Product)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭session
			//closeSession();
		}
		return pro;
	}

}
