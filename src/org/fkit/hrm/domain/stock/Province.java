package org.fkit.hrm.domain.stock;

/**
 * 中国省表
 * 
 * @author Sampson
 *
 */
public class Province {
	private Integer id;
	private String provinceid;
	private String province;

	public Province() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceid=" + provinceid + ", province=" + province + "]";
	}

}
