/**
 * 
 */
package org.fkit.hrm.dao.stock;

import static org.fkit.hrm.util.common.HrmConstants.PROVINCETABLE;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.hrm.domain.stock.Province;

/**
 * 地址表查询
 * 
 * @author Sampson
 *
 */
public interface ProvinceDao {

	@Select("select * from " + PROVINCETABLE + " ")
	List<Province> getAllProvinces();
}
