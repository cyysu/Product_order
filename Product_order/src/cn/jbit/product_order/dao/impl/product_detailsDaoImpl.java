package cn.jbit.product_order.dao.impl;

import org.hibernate.Query;
import org.hibernate.Transaction;

import org.hibernate.Session;

import cn.jbit.product_order.dao.hibernteUtil;
import cn.jbit.product_order.dao.product_detailsDao;
import cn.jbit.product_order.entity.OrdersDetails;

public class product_detailsDaoImpl extends hibernteUtil implements product_detailsDao{

	@Override
	public int save(OrdersDetails orderdetails) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.save(orderdetails);	
			//提交事务
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@Override
	public int deleteById(int orderdeid) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = currentSession();
			//开启事务
			tx = session.beginTransaction();
			OrdersDetails dis = (OrdersDetails)session.get(OrdersDetails.class, orderdeid);
			session.delete(dis);
			//提交事务
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}finally{
			//关闭session
			//closeSession();
		}
	}

	@Override
	public OrdersDetails getById(int ordeId) {
		Session session = null;
		OrdersDetails orderdetails = null;
		try {
			//打开session
			session = currentSession();
			Query query = session.createQuery("from OrdersDetails as orde where orde.id = ?");
			query.setInteger(0, ordeId);
			/**
			 * 通过    uniqueResult  获取值
			 */
			orderdetails =(OrdersDetails)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭session
			//closeSession();
		}
		return orderdetails;
	}

}
