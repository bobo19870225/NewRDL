package org.fkit.hrm.dao.provider.stock;

import static org.fkit.hrm.util.common.HrmConstants.GOODSTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.stock.Goods;

public class GoodsDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(GOODSTABLE);
				if (params.get("goods") != null) {
					Goods goods = (Goods) params.get("goods");
					if (goods.getId() != null && goods.getId() != 0) {
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
				FROM(GOODSTABLE);
				if (params.get("goods") != null) {
					Goods goods = (Goods) params.get("goods");
					if (goods.getId() != null && goods.getId() != 0) {
						WHERE(" goodsId = #{stock.goodsId} ");
					}
				}
			}
		}.toString();
	}
}
