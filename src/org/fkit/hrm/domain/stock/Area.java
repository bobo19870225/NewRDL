package org.fkit.hrm.domain.stock;

/**
 * 区表
 * 
 * @author Sampson
 *
 */
public class Area {
	private Integer id;
	private String areaid;
	private String area;
	private String cityid;

	public Area() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	@Override
	public String toString() {
		return "Areas [id=" + id + ", areaid=" + areaid + ", area=" + area + ", cityid=" + cityid + "]";
	}

}
