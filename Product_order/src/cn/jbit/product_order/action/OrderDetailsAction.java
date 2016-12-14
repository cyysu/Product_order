package cn.jbit.product_order.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.jbit.product_order.dao.ordersDao;
import cn.jbit.product_order.dao.productDao;
import cn.jbit.product_order.dao.product_detailsDao;
import cn.jbit.product_order.dao.impl.ordersDaoImpl;
import cn.jbit.product_order.dao.impl.productDaoImpl;
import cn.jbit.product_order.dao.impl.product_detailsDaoImpl;
import cn.jbit.product_order.entity.Orders;
import cn.jbit.product_order.entity.OrdersDetails;
import cn.jbit.product_order.entity.Product;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderDetailsAction extends ActionSupport{
	private int orderdetailId;
	
	public int getOrderdetailId() {
		return orderdetailId;
	}
	public void setOrderdetailId(int orderdetailId) {
		this.orderdetailId = orderdetailId;
	}
	public void validate(){
		if(this.getOrderdetailId()<1010||"".equals(this.getOrderdetailId())){
			addFieldError("orderdetailId", "²»ÄÜÎª¿Õ");
		}
	}
	@Override
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		product_detailsDao prode=new product_detailsDaoImpl();
		OrdersDetails ordetail=prode.getById(orderdetailId);
		session.setAttribute("orderdetailDetail", ordetail);
		ordersDao orderdao=new ordersDaoImpl();
		Orders orderDetail=orderdao.getById(ordetail.getOrders().getId());
		session.setAttribute("orderDetail", orderDetail);
		productDao prodDetail=new productDaoImpl();
		Product produdetails=prodDetail.getById(ordetail.getProduct().getId());
		session.setAttribute("produdetails", produdetails);
		Double total=getTalPrice(orderDetail);
		session.setAttribute("total", total);
		return "success";
	}
	public Double getTalPrice(Orders order){
		double total=0.0;
		for(OrdersDetails oi:order.getOrdersDetailses()){
			total+= oi.getAmount()*oi.getProduct().getPrice();
		}
		return total;
	}
}
