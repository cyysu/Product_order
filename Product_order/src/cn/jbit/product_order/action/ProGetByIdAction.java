package cn.jbit.product_order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.jbit.product_order.dao.productDao;
import cn.jbit.product_order.dao.impl.productDaoImpl;
import cn.jbit.product_order.entity.Product;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProGetByIdAction extends ActionSupport implements Action  {
	private String[] proid;
	public String[] getProid() {
		return proid;
	}
	public void setProid(String[] proid) {
		this.proid = proid;
	}
	@Override
	public String execute() throws Exception {
		int proids = 0;
		Product pro=null;
		List<Product> List=new ArrayList<Product>();
		for(int i=0;i<this.getProid().length;i++){  
            String chkNameValue=this.getProid()[i];  
            proids=Integer.parseInt(chkNameValue);
            productDao product=new productDaoImpl();
    		pro=product.getById(proids);
    		List.add(pro);
		}   
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("product", List);
		return SUCCESS;
	}
	public void validate(){
		if(this.getProid()==null||"".equals(this.getProid())){
			addFieldError("proid", "ÇëÑ¡Ôñ");
		}
	}
}
