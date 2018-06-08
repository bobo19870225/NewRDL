
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.BUYERTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.Buyer;

/**
 * 买家表
 * 
 * @author Sampson
 *
 */
public interface BuyerDao {
	@Select("select * from " + BUYERTABLE + " ")
	List<Buyer> getAllBuyer();

	@Select("select * from " + BUYERTABLE + " where ID=${id}")
	Buyer getBuyerDetails(@Param("id") Integer id);//@Param("id")不加上会有bug
}
