package cn.jbit.product_order.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Orders implements java.io.Serializable {
	
		private Integer id;
		private String name;
		private String address;
		private Date createtime;
		private Set<OrdersDetails> ordersDetailses = new HashSet<OrdersDetails>();
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
		public Set<OrdersDetails> getOrdersDetailses() {
			return ordersDetailses;
		}
		public void setOrdersDetailses(Set<OrdersDetails> ordersDetailses) {
			this.ordersDetailses = ordersDetailses;
		}
		public Orders(String name, String address, Date createtime,
				Set<OrdersDetails> ordersDetailses) {
			this.name = name;
			this.address = address;
			this.createtime = createtime;
			this.ordersDetailses = ordersDetailses;
		}
		public Orders() {
		}
		
}
