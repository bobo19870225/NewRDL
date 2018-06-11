
package org.fkit.hrm.controller.stock;

import java.util.List;

import org.fkit.hrm.dao.stock.MessageDao;
import org.fkit.hrm.domain.stock.Goods;
import org.fkit.hrm.service.StockService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Sampson
 * @Description 商品API
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/json")
public class GoodsJsonController {
	/**
	 * 自动注入Service
	 */
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;
	@Autowired
	private MessageDao<Goods> messageDao;

	@RequestMapping(value = "/getGoodsList")
	@ResponseBody
	public Object getGoodsList(@RequestParam(name = "pageIndex") Integer pageIndex,
			@RequestParam(name = "pageSize", required = false) Integer pageSize, @ModelAttribute Goods goods) {
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		List<Goods> goodsList = stockService.getGoodsList(goods, pageModel);
		return messageDao.getMessage(goodsList);
	}

	@RequestMapping(value = "/getGoodsDetails")
	@ResponseBody
	public Object getGoodsDetails(@RequestParam("id") Integer id) {
		Goods goods = stockService.getOneGoodsDetails(id);
		return messageDao.getMessage(goods);
	}
}
