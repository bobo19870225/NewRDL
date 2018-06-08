package org.fkit.hrm.dao.provider.stock;

import static org.fkit.hrm.util.common.HrmConstants.STOCKTABLE;
import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.stock.Stock;

public class StockDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(STOCKTABLE);
				if (params.get("stock") != null) {
					Stock stock = (Stock) params.get("stock");
					if (stock.getGoodsId() != null && stock.getGoodsId() != 0) {
						WHERE(" goodsId = #{stock.goodsId} ");
					}
				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}

		return sql;
	}

	// 动态查询总数量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(STOCKTABLE);
				if (params.get("stock") != null) {
					Stock stock = (Stock) params.get("stock");
					if (stock.getGoodsId() != null && stock.getGoodsId() != 0) {
						WHERE(" goodsId = #{stock.goodsId} ");
					}
				}
			}
		}.toString();
	}
}
