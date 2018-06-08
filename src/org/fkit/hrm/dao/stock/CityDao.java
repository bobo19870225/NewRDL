/**
 * 
 */
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.CITYTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.City;

/**
 * 地址表查询
 * 
 * @author Sampson
 *
 */
public interface CityDao {

	@Select("select * from " + CITYTABLE + " where provinceid = ${provinceid}")
	List<City> getCityListByProvinceId(@Param("provinceid") Integer provinceid);

}
