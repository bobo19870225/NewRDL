/**
 * 库存业务接口
 */
package org.fkit.hrm.service;

import java.util.List;

import org.fkit.hrm.domain.stock.Address;
import org.fkit.hrm.domain.stock.Area;
import org.fkit.hrm.domain.stock.Buyer;
import org.fkit.hrm.domain.stock.City;
import org.fkit.hrm.domain.stock.Goods;
import org.fkit.hrm.domain.stock.Order;
import org.fkit.hrm.domain.stock.Province;
import org.fkit.hrm.domain.stock.Stock;
import org.fkit.hrm.util.tag.PageModel;

/**
 * @Description 库存业务接口
 * @author Sampson
 * @version V1.0
 */
public interface StockService {
	/**
	 * 
	 * @param stock
	 * @param pageModel
	 *            分页信息
	 * @return 带分页的库存记录列表
	 */
	List<Goods> getGoodsList(Goods goods, PageModel pageModel);

	/**
	 * 获取某个商品的详情
	 * 
	 * @param id
	 *            商品id
	 * @return 商品
	 */
	Goods getOneGoodsDetails(int id);

	/**
	 * 订单列表
	 * 
	 * @return 订单列表
	 */
	List<Order> getAllOrder();

	/**
	 * 获取某个订单详情
	 * 
	 * @return 订单详情
	 */
	Order getOrderDetails(int id);

	/**
	 * 获取买家列表
	 * 
	 * @return 买家列表
	 */
	List<Buyer> getAllBuyer();

	/**
	 * 获取某个买家详情
	 * 
	 * @return 买家详情
	 */
	Buyer getBuyerDetails(Integer id);

	/**
	 * 
	 * @param stock
	 * @param pageModel
	 *            分页信息
	 * @return 带分页的库存记录列表
	 */
	List<Stock> getStockList(Stock stock, PageModel pageModel);

	/**
	 * 获取某个库存记录详情
	 * 
	 * @param id
	 *            库存id
	 * @return 库存记录详情
	 */
	Stock getStockDetails(int id);

	/**
	 * 获取某个买家地址详情
	 * 
	 * @param buyerId
	 *            买家id
	 * @return 买家地址详情
	 */
	Address getAddressDetails(Integer buyerId);

	/**
	 * 获取所有省市名称
	 * 
	 * @return 所有省市名称列表
	 */
	List<Province> getAllProvinces();

	/**
	 * 获取某个省份的城市列表
	 * 
	 * @param provinceId
	 *            省份Id
	 * @return 某个省份的城市列表
	 */
	List<City> getCityListByProvinceId(Integer provinceId);

	/**
	 * 获取某个城市的区域列表
	 * 
	 * @param cityId
	 *            城市id
	 * @return 某个城市的区域列表
	 */
	List<Area> getAreaListByCityId(Integer cityId);

}
