/**
 * 
 */
package org.fkit.hrm.domain.stock;

/**
 * 订单项目表
 * 
 * @author Sampson
 *
 */
public class OrderItem {
	private int id;
	private int orderId;
	private int gooodsId;
	private int goodsAmount;

	public OrderItem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGooodsId() {
		return gooodsId;
	}

	public void setGooodsId(int gooodsId) {
		this.gooodsId = gooodsId;
	}

	public int getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(int goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", gooodsId=" + gooodsId + ", goodsAmount="
				+ goodsAmount + "]";
	}

}
