/**
 * 
 */
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.ORDERTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.Order;

/**
 * 订单查询接口
 * 
 * @author Sampson
 *
 */
public interface OrderDao {
	@Select("select * from " + ORDERTABLE + " ")
	List<Order> selectAllOrder();

	@Select("select * from " + ORDERTABLE + " where ID = ${id}")
	Order selectOrderById(@Param("id")int id);
}
