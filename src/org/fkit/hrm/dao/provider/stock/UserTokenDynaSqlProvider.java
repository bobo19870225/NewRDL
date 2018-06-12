package org.fkit.hrm.dao.provider.stock;

import static org.fkit.hrm.util.common.HrmConstants.USERTOKENTABLE;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.stock.UserToken;

public class UserTokenDynaSqlProvider {
	// 动态插入
	public String insertUserToken(UserToken userToken) {

		return new SQL() {
			{
				INSERT_INTO(USERTOKENTABLE);
				if (userToken.getUserId() != null) {
					VALUES("userId", "#{userId}");
				}
				if (userToken.getToken() != null && !userToken.getToken().equals("")) {
					VALUES("token", "#{token}");
				}
				if (userToken.getCreateTime() != null) {
					VALUES("createTime", "#{createTime}");
				}
				if (userToken.getRefreshTime() != null) {
					VALUES("refreshTime", "#{refreshTime}");
				}
				if (userToken.getValidTime() != null) {
					VALUES("validTime", "#{valdiTime}");
				}
				if (userToken.getIsValid() != null) {
					VALUES("isValid", "#{isValid}");
				}
			}
		}.toString();
	}

	// 动态查询
	public String selectWhitParam(UserToken userToken) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTOKENTABLE);

				if (userToken.getId() != null) {
					WHERE(" id = #{id}");
				}
				if (userToken.getUserId() != null) {
					WHERE(" userId = #{userId}");
				}

			}
		}.toString();
		return sql;
	}

	// 动态更新
	public String updateUserToken(UserToken userToken) {

		return new SQL() {
			{
				UPDATE(USERTOKENTABLE);
				if (userToken.getUserId() != null) {
					SET(" userId = #{userId} ");
				}
				if (userToken.getToken() != null) {
					SET(" token = #{token} ");
				}
				if (userToken.getRefreshTime() != null) {
					SET(" refreshTime = #{refreshTime} ");
				}
				if (userToken.getValidTime() != null) {
					SET(" validTime = #{validTime} ");
				}
				if (userToken.getIsValid() != null) {
					SET(" isValid = #{isValid} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}