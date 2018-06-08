/**
 * 
 */
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.ADDRESSTABLE;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.Address;

/**
 * 地址表查询
 * 
 * @author Sampson
 *
 */
public interface AddressDao {

	@Select("select * from " + ADDRESSTABLE + " where buyerId = ${buyerId}")
	Address getBuyerAddressDetails(@Param("buyerId") Integer buyerId);
}
