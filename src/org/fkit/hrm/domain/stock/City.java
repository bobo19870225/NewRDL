package org.fkit.hrm.domain.stock;

/**
 * 城市表
 * 
 * @author Sampson
 *
 */
public class City {
	private Integer id;
	private String cityid;
	private String city;
	private String provinceid;

	public City() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityid=" + cityid + ", city=" + city + ", provinceid=" + provinceid + "]";
	}

}
