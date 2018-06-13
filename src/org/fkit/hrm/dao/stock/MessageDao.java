package org.fkit.hrm.dao.stock;
/**
 * 消息处理
 * @author Sampson
 *
 */

import java.util.List;
import java.util.Map;

import org.fkit.hrm.domain.stock.Message;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用来拼接移动端API的内容
 * 
 * @author Sampson
 *
 * @param <T>
 */
@Component
// @Scope(scopeName = "request")//需要在web.xml中配置
// <listener>
// <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
// </listener>
public class MessageDao<T> {

	public MessageDao() {
		super();
	}

	@Autowired
	private Message<T> message;

	@SuppressWarnings("unchecked")
	public Message<T> getMessage(Object content) {
		message.clean();
		if (content != null) {
			message.setCode(0);
			message.setMsg("查询成功！");
			if (content instanceof List) {
				message.setContentList((List<T>) content);
			} else {
				message.setContent((T) content);
			}
		} else {
			message.setCode(1001);
			message.setMsg("查询失败！");
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	public Message<T> getMessage(Map<String, Object> map) {
		message.clean();
		Object content = map.get("content");
		if (content != null) {
			message.setCode(0);
			message.setMsg("查询成功！");
			PageModel pageModel = (PageModel) map.get("pageModel");
			if (pageModel != null) {
				message.setPageModel(pageModel);
			}
			if (content instanceof List) {
				message.setContentList((List<T>) content);
			} else {
				message.setContent((T) content);
			}
		} else {
			message.setCode(1001);
			message.setMsg("查询失败！");
		}
		return message;
	}
}
