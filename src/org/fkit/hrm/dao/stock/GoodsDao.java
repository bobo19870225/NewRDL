package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.GOODSTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.Goods;

public interface GoodsDao {
	@Select("select * from " + GOODSTABLE + " ")
	List<Goods> selectAllGoods();

	@Select("select * from " + GOODSTABLE + " where ID = #{id}")
	Goods selectById(int id);
	
}
