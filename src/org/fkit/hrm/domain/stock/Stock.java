/**
 * 
 */
package org.fkit.hrm.domain.stock;

import java.sql.Date;

/**
 * 库存表
 * 
 * @author Sampson
 *
 */
public class Stock {
	private Integer id;
	private Integer goodsId;
	private Integer QOH;// 现有数量
	private Integer changes;// 变动数量
	private Date data;
	private String remarks;

	public Stock() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getQOH() {
		return QOH;
	}

	public void setQOH(Integer qOH) {
		QOH = qOH;
	}

	public Integer getChanges() {
		return changes;
	}

	public void setChanges(Integer changes) {
		this.changes = changes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", goodsId=" + goodsId + ", QOH=" + QOH + ", changes=" + changes + ", data=" + data
				+ ", remarks=" + remarks + "]";
	}

}
