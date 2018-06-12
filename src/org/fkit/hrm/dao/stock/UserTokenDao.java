/**
 * 
 */
package org.fkit.hrm.dao.stock;

import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.stock.UserTokenDynaSqlProvider;
import org.fkit.hrm.domain.stock.UserToken;

/**
 * Token表查询
 * 
 * @author Sampson
 *
 */
public interface UserTokenDao {

	// 动态查询用户Token
	@SelectProvider(type = UserTokenDynaSqlProvider.class, method = "selectWhitParam")
	UserToken getUserTokenDetails(UserToken userToken);

	// 动态修改用户Token
	@SelectProvider(type = UserTokenDynaSqlProvider.class, method = "updateUserToken")
	void update(UserToken userToken);

	// 动态插入用户Token
	@SelectProvider(type = UserTokenDynaSqlProvider.class, method = "insertUserToken")
	void insert(UserToken userToken);
}
