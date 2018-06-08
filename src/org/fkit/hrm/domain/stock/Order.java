package org.fkit.hrm.domain.stock;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * 订单表
 * 
 * @author Sampson
 *
 */
public class Order {
	private int orderId;
	private int buyerId;
	private Date orderDate;
	private BigDecimal freight;
	private BigDecimal totalPrice;
	private List<OrderItem> orderItemList;

	public Order() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", buyerId=" + buyerId + ", orderDate=" + orderDate + ", freight="
				+ freight + ", totalPrice=" + totalPrice + ", orderItemList=" + orderItemList + "]";
	}

}
