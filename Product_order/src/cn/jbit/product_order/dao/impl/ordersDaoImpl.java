package cn.jbit.product_order.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.jbit.product_order.dao.hibernteUtil;
import cn.jbit.product_order.dao.ordersDao;
import cn.jbit.product_order.entity.Orders;

public class ordersDaoImpl extends hibernteUtil implements ordersDao{

	@Override
	public int save(Orders orders) {
		Transaction tx = null;
		Session session = null;
		try {
			//��session
			session = currentSession();
			//��������
			tx = session.beginTransaction();
			session.save(orders);	
			//�ύ����
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			//�ر�session
			//closeSession();
		}
	}

	@Override
	public void deleteById(int orderid) {
		
	}

	@Override
	public Orders getById(int orderid) {
		Session session = null;
		Orders order = null;
		try {
			//��session
			session = currentSession();
			Query query = session.createQuery("from Orders as order where order.id = ?");
			query.setInteger(0, orderid);
			/**
			 * ͨ��    uniqueResult  ��ȡֵ
			 */
			order =(Orders)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر�session
			//closeSession();
		}
		return order;
	}

}
