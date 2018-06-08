package org.fkit.hrm.controller.stock;

import javax.servlet.http.HttpSession;

import org.fkit.hrm.dao.stock.MessageDao;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.common.HrmConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理用户请求控制器
 */
@Controller
@RequestMapping(value = "/json")
public class UserJsonController {
	/**
	 * 自动注入UserService
	 */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	@Autowired
	private MessageDao<User> messageDao;

	/**
	 * 处理登录请求
	 * 
	 * @param String
	 *            loginname 登录名
	 * @param String
	 *            password 密码
	 * @return Object 格式的数据
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public Object login(@RequestParam("loginname") String loginname, @RequestParam("password") String password,
			HttpSession session) {
		// 调用业务逻辑组件判断用户是否可以登录
		User user = hrmService.login(loginname, password);
		if (user != null) {
			// 将用户保存到HttpSession当中
			session.setAttribute(HrmConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			// mv.setViewName("redirect:/main");
		} else {
			// 设置登录失败提示信息
			// mv.addObject("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			// mv.setViewName("forward:/loginForm");
		}
		return messageDao.getMessage(user);
		// return mv;

	}
}