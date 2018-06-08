/**
 * 
 */
package org.fkit.hrm.controller.stock;

import org.fkit.hrm.dao.stock.MessageDao;
import org.fkit.hrm.domain.stock.Address;
import org.fkit.hrm.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Sampson
 *
 */
@Controller
@RequestMapping(value = "json")
public class ProvinceJsonController {
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;
	@Autowired
	private MessageDao<Address> messageDao;

	@RequestMapping(value = "getAllProvinceList")
	@ResponseBody
	public Object getAllProvinceList() {
		return messageDao.getMessage(stockService.getAllProvinces());
	}
}
