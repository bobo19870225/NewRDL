
package org.fkit.hrm.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fkit.hrm.dao.stock.AddressDao;
import org.fkit.hrm.dao.stock.AreaDao;
import org.fkit.hrm.dao.stock.BuyerDao;
import org.fkit.hrm.dao.stock.CityDao;
import org.fkit.hrm.dao.stock.GoodsDao;
import org.fkit.hrm.dao.stock.OrderDao;
import org.fkit.hrm.dao.stock.ProvinceDao;
import org.fkit.hrm.dao.stock.StockDao;
import org.fkit.hrm.domain.stock.Address;
import org.fkit.hrm.domain.stock.Area;
import org.fkit.hrm.domain.stock.Buyer;
import org.fkit.hrm.domain.stock.City;
import org.fkit.hrm.domain.stock.Goods;
import org.fkit.hrm.domain.stock.Order;
import org.fkit.hrm.domain.stock.Province;
import org.fkit.hrm.domain.stock.Stock;
import org.fkit.hrm.service.StockService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sampson
 * @Description 库存业务逻辑实现
 * @version v1.0
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("stockService")
public class StockServiceImpl implements StockService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private BuyerDao buyerDao;
	@Autowired
	private StockDao stockDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private AreaDao areaDao;

	/**
	 * @see StockService
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Goods> getAllGoods() {
		return goodsDao.selectAllGoods();
	}

	@Transactional(readOnly = true)
	@Override
	public Goods getOneGoodsDetails(int id) {
		return goodsDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Order> getAllOrder() {
		return orderDao.selectAllOrder();
	}

	@Transactional(readOnly = true)
	@Override
	public Order getOrderDetails(int id) {
		return orderDao.selectOrderById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Buyer> getAllBuyer() {
		return buyerDao.getAllBuyer();
	}

	@Transactional(readOnly = true)
	@Override
	public Buyer getBuyerDetails(Integer id) {
		return buyerDao.getBuyerDetails(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Stock> getAllStock() {
		return stockDao.selectAllStock();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Stock> getStockList(Stock stock, PageModel pageModel) {
		/** 当前需要分页的总数据条数 */
		Map<String, Object> params = new HashMap<>();
		params.put("stock", stock);
		int recordCount = stockDao.count(params);
		pageModel.setRecordCount(recordCount);
		if (recordCount > 0) {
			/** 开始分页查询数据：查询第几页的数据 */
			params.put("pageModel", pageModel);
		}
		List<Stock> stockList = stockDao.selectByPage(params);
		return stockList;
	}

	@Transactional(readOnly = true)
	@Override
	public Stock getStockDetails(int id) {
		return stockDao.getStockDetails(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Address getAddressDetails(Integer buyerId) {
		return addressDao.getBuyerAddressDetails(buyerId);
	}

	@Override
	public List<Province> getAllProvinces() {
		return provinceDao.getAllProvinces();
	}

	@Override
	public List<City> getCityListByProvinceId(Integer provinceId) {
		return cityDao.getCityListByProvinceId(provinceId);
	}

	@Override
	public List<Area> getAreaListByCityId(Integer cityId) {
		return areaDao.getAreaListByCityId(cityId);
	}

}
