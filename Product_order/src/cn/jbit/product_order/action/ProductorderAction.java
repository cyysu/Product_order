package cn.jbit.product_order.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.jbit.product_order.entity.Orders;
import cn.jbit.product_order.entity.OrdersDetails;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProductorderAction extends ActionSupport {
	public String execute() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		String[] prodid=(String[]) session.getAttribute("produidinfo");
		Orders order= (Orders) session.getAttribute("orderinfo");
		OrdersDetails orderdetails=(OrdersDetails) session.getAttribute("ordetailinfo");
	return SUCCESS;	
	}
}
