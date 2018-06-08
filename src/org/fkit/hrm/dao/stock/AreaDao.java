/**
 * 
 */
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.AREATABLE;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.Area;

/**
 * 地址表查询
 * 
 * @author Sampson
 *
 */
public interface AreaDao {

	@Select("select * from " + AREATABLE + " where cityid = ${cityid}")
	List<Area> getAreaListByCityId(@Param("cityid") Integer cityid);

}
