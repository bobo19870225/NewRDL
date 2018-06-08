/**
 * 
 */
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.STOCKTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.stock.StockDynaSqlProvider;
import org.fkit.hrm.domain.stock.Stock;

/**
 * 库存表接口
 * 
 * @author Sampson
 *
 */
public interface StockDao {
	@Select("select * from " + STOCKTABLE + " ")
	List<Stock> selectAllStock();

	/**
	 * 动态查询
	 * 
	 * @param params
	 *            一个Stock和一个PageModel实例
	 * @return 带分页的库存列表
	 */
	@SelectProvider(type = StockDynaSqlProvider.class, method = "selectWhitParam")
	List<Stock> selectByPage(Map<String, Object> params);

	@Select("select * from " + STOCKTABLE + " where id = ${id}")
	Stock getStockDetails(int id);

	// 根据参数查询库存总数
	@SelectProvider(type = StockDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
}
