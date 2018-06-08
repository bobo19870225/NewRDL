/**
 * 
 */
package org.fkit.hrm.domain.stock;

/**
 * 买家收货地址
 * 
 * @author Sampson
 *
 */
public class Address {
	private Integer id;
	private Integer buyerId;
	private String province;
	private String city;
	private String areas;
	private String address;

	public Address() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", buyerId=" + buyerId + ", province=" + province + ", city=" + city + ", areas="
				+ areas + ", address=" + address + "]";
	}

}
