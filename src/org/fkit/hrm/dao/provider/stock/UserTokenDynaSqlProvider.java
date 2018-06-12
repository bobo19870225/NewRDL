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
				if (userToken.getUserToken() != null && !userToken.getUserToken().equals("")) {
					VALUES("userToken", "#{userId}");
				}
				if (userToken.getCreateTime() != null) {
					VALUES("createTime", "#{createTime}");
				}
				if (userToken.getRefreshTime() != null) {
					VALUES("refreshTime", "#{refreshTime}");
				}
				if (userToken.getVaildTime() != null) {
					VALUES("vaildTime", "#{vaildTime}");
				}
				if (userToken.getIsVaild() != null) {
					VALUES("isVaild", "#{isVaild}");
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
				if (userToken.getUserToken() != null) {
					SET(" userToken = #{userToken} ");
				}
				if (userToken.getRefreshTime() != null) {
					SET(" refreshTime = #{refreshTime} ");
				}
				if (userToken.getVaildTime() != null) {
					SET(" vaildTime = #{vaildTime} ");
				}
				if (userToken.getIsVaild() != null) {
					SET(" isVaild = #{isVaild} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}