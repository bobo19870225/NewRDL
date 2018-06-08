package org.fkit.hrm.controller.stock;

import java.util.List;

import org.fkit.hrm.dao.stock.MessageDao;
import org.fkit.hrm.domain.stock.Buyer;
import org.fkit.hrm.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/json")
public class BuyerJsonController {
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;
	@Autowired
	private MessageDao<Buyer> messageDao;

	@RequestMapping(value = "/getAllBuyer")
	@ResponseBody
	public Object getAllBuyer() {
		List<Buyer> buyerList = stockService.getAllBuyer();
		return messageDao.getMessage(buyerList);
	}

	@RequestMapping(value = "/getBuyerDetails")
	@ResponseBody
	public Object getBuyerDetails(@RequestParam("id") Integer id) {
		Buyer buyer = stockService.getBuyerDetails(id);
		return messageDao.getMessage(buyer);
	}
}
