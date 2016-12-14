package cn.jbit.product_order.entity;


@SuppressWarnings("serial")
public class OrdersDetails  implements java.io.Serializable {

	private Integer id;
	private Orders orders;
	private Product product;
	private int amount;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrdersDetails(Orders orders, Product product, Integer amount) {
		this.orders = orders;
		this.product = product;
		this.amount = amount;
	}
	public OrdersDetails() {
	}

}
