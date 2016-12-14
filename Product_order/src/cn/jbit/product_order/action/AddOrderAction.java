package cn.jbit.product_order.action;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class AddOrderAction extends ActionSupport{
	private String shouhuoname="";
	private String address="";
	private String[] number;
	private String[] productid;
	private Product pro;
	private Orders order;
	private OrdersDetails ordetail;
	private product_detailsDao prodetail=new product_detailsDaoImpl();
	private productDao productdao=new productDaoImpl();
	private ordersDao orderdao=new ordersDaoImpl();
	@Override
	public String execute() throws Exception{
		HttpSession session=ServletActionContext.getRequest().getSession();
		//订单
			//收货人、收货地址、创建时间
		order=new Orders();
		
		//订单明细
			//商品编号、订单编号、商品数量
			//数量
			int num=0;
			//商品编号
			int productids=0;
			int result=0;
			ordetail=new OrdersDetails();
			for(int j=0;j<productid.length;j++){
				order.setName(shouhuoname);
				order.setAddress(address);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String dates=df.format(new Date());
				Date date = df.parse(dates);
				order.setCreatetime(date);
				num=Integer.parseInt(number[j]);
				productids=Integer.parseInt(productid[j]);
				Product pro=productdao.getById(productids);
				ordetail.setAmount(num);
				ordetail.setOrders(order);
				ordetail.setProduct(pro);
				
				order.getOrdersDetailses().add(ordetail);
				result=orderdao.save(order);
				prodetail.save(ordetail);
				}
			if(result>0){
				session.setAttribute("orderinfo", order);
				session.setAttribute("ordetailinfo", ordetail);
				Double total=getTalPrice(order);
				session.setAttribute("total", total);
				return SUCCESS;
			}else{
				return INPUT;
			}
	}
	public Double getTalPrice(Orders order){
		double total=0.0;
		for(OrdersDetails oi:order.getOrdersDetailses()){
			total+= oi.getAmount()*oi.getProduct().getPrice();
		}
		return total;
	}
	public void validate(){
		if(this.getShouhuoname()==null||"".equals(this.getShouhuoname())){
			addFieldError("shouhuoname", "收货人不能为空");
		}
		if(this.getAddress()==null||"".equals(this.getAddress())){
			addFieldError("address", "收货地址不能为空");
		}
		if(this.getNumber()==null||"".equals(this.getNumber())){
			addFieldError("number", "数量不能为空");
		}
	}
	
	public String[] getProductid() {
		return productid;
	}
	public void setProductid(String[] productid) {
		this.productid = productid;
	}
	public product_detailsDao getProdetail() {
		return prodetail;
	}
	public void setProdetail(product_detailsDao prodetail) {
		this.prodetail = prodetail;
	}
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public OrdersDetails getOrdetail() {
		return ordetail;
	}
	public void setOrdetail(OrdersDetails ordetail) {
		this.ordetail = ordetail;
	}
	public String getShouhuoname() {
		return shouhuoname;
	}

	public void setShouhuoname(String shouhuoname) {
		this.shouhuoname = shouhuoname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getNumber() {
		return number;
	}

	public void setNumber(String[] number) {
		this.number = number;
	}
}
