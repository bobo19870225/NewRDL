package org.fkit.hrm.domain.stock;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 商品表
 * 
 * @author Sampson
 *
 */
public class Goods {
	private int id;
	private String number;
	private String goodsName;
	private BigDecimal unitPrice;// 单价
	private BigDecimal costPrice;// 成本价
	private Date productionDate;
	private String manufacturer;// 生产厂家
	private String remarks;// 备注

	public Goods() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", number=" + number + ", goodsName=" + goodsName + ", unitPrice=" + unitPrice
				+ ", costPrice=" + costPrice + ", productionDate=" + productionDate + ", manufacturer=" + manufacturer
				+ ", remarks=" + remarks + "]";
	}

}
