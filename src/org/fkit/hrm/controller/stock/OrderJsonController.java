package org.fkit.hrm.controller.stock;

import java.util.List;

import org.fkit.hrm.dao.stock.MessageDao;
import org.fkit.hrm.domain.stock.Order;
import org.fkit.hrm.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单表
 * 
 * @author Sampson
 *
 */
@Controller
@RequestMapping(value = "/json")
public class OrderJsonController {
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;
	@Autowired
	private MessageDao<Order> messageDao;

	@RequestMapping(value = "/getAllOrder")
	@ResponseBody
	public Object getAllOrder() {
		List<Order> orderList = stockService.getAllOrder();
		return messageDao.getMessage(orderList);
	}

	@RequestMapping(value = "/getOrderDetails")
	@ResponseBody
	public Object getOrderDetails(@RequestParam("id") int id) {
		Order order = stockService.getOrderDetails(id);
		return messageDao.getMessage(order);
	}
}
