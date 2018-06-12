package org.fkit.hrm.domain.stock;

import java.sql.Date;

public class UserToken {
	private Integer id;
	private Integer userId;
	private String userToken;
	private Date createTime;
	private Date refreshTime;
	private Date vaildTime;
	private Integer isVaild;

	public UserToken() {
		super();
	}

	public UserToken(Integer id, Integer userId, String userToken, Date createTime, Date refreshTime, Date vaildTime,
			Integer isVaild) {
		super();
		this.id = id;
		this.userId = userId;
		this.userToken = userToken;
		this.createTime = createTime;
		this.refreshTime = refreshTime;
		this.vaildTime = vaildTime;
		this.isVaild = isVaild;
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

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
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

	public Date getVaildTime() {
		return vaildTime;
	}

	public void setVaildTime(Date vaildTime) {
		this.vaildTime = vaildTime;
	}

	public Integer getIsVaild() {
		return isVaild;
	}

	public void setIsVaild(Integer isVaild) {
		this.isVaild = isVaild;
	}

	@Override
	public String toString() {
		return "UserToken [id=" + id + ", userId=" + userId + ", userToken=" + userToken + ", createTime=" + createTime
				+ ", refreshTime=" + refreshTime + ", vaildTime=" + vaildTime + ", isVaild=" + isVaild + "]";
	}

}
