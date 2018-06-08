/**
 * 
 */
package org.fkit.hrm.controller.stock;

import java.util.List;

import org.fkit.hrm.domain.stock.Stock;
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
 * 库存API
 * 
 * @author Sampson
 *
 */
@Controller
@RequestMapping(value = "/json")
public class StockJsonController {
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;

	@RequestMapping(value = "/getStockListByGoodsId")
	@ResponseBody
	public List<Stock> getStockListByGoodsId(@RequestParam("goodsId") Integer goodsid,
			@RequestParam(name = "pageIndex") Integer pageIndex,
			@RequestParam(name = "pageSize", required = false) Integer pageSize, @ModelAttribute Stock stock) {

		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		return stockService.getStockList(stock, pageModel);
	}
}
