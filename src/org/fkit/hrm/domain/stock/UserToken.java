package org.fkit.hrm.domain.stock;

import java.sql.Date;

public class UserToken {
	private Integer id;
	private Integer userId;
	private String token;
	private Date createTime;
	private Date refreshTime;
	private Date validTime;
	private Integer isValid;

	public UserToken() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(Date refreshTime) {
		this.refreshTime = refreshTime;
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "UserToken [id=" + id + ", userId=" + userId + ", token=" + token + ", createTime=" + createTime
				+ ", refreshTime=" + refreshTime + ", validTime=" + validTime + ", isValid=" + isValid + "]";
	}

}
