package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.GOODSTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.stock.GoodsDynaSqlProvider;
import org.fkit.hrm.dao.provider.stock.StockDynaSqlProvider;
import org.fkit.hrm.domain.stock.Goods;

public interface GoodsDao {
	@Select("select * from " + GOODSTABLE + " ")
	List<Goods> selectAllGoods();

	/**
	 * 动态查询
	 * 
	 * @param params
	 *            一个Goods和一个PageModel实例
	 * @return 带分页的库存列表
	 */
	@SelectProvider(type = GoodsDynaSqlProvider.class, method = "selectWhitParam")
	List<Goods> selectByPage(Map<String, Object> params);

	// 根据参数查询库存总数
	@SelectProvider(type = GoodsDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	@Select("select * from " + GOODSTABLE + " where ID = #{id}")
	Goods selectById(int id);

}
