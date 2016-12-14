package cn.jbit.product_order.entity;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Product implements java.io.Serializable {
	private Integer id;
	private Double price;
	private String name;
	private String specification;
	private String manufacturer;
	private Set<OrdersDetails> ordersDetailses = new HashSet<OrdersDetails>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Set<OrdersDetails> getOrdersDetailses() {
		return ordersDetailses;
	}
	public void setOrdersDetailses(Set<OrdersDetails> ordersDetailses) {
		this.ordersDetailses = ordersDetailses;
	}
	public Product( Double price, String name, String specification,
			String manufacturer, Set<OrdersDetails> ordersDetailses) {
		this.price = price;
		this.name = name;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.ordersDetailses = ordersDetailses;
	}
	public Product() {
	}
	

}
