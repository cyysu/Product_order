package cn.jbit.product_order.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.jbit.product_order.dao.productDao;
import cn.jbit.product_order.dao.impl.productDaoImpl;
import cn.jbit.product_order.entity.Product;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class productAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		productDao product=new productDaoImpl();
		List<Product> proList=product.getAll();
		session.setAttribute("proList", proList);
		return "success";
	}
}		
