package org.fkit.hrm.controller.stock;

import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.fkit.hrm.dao.stock.MessageDao;
import org.fkit.hrm.dao.stock.UserTokenDao;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.domain.stock.UserToken;
import org.fkit.hrm.service.HrmService;
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
	@Autowired
	private UserTokenDao userTokenDao;

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
			// uuid作为token
			String access_token = UUID.randomUUID().toString();
			UserToken newUserToken = new UserToken();
			newUserToken.setUserId(user.getId());
			UserToken userToken = userTokenDao.getUserTokenDetails(newUserToken);
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			if (userToken == null) {// 没有Token就插入一个
				newUserToken.setToken(access_token);
				newUserToken.setCreateTime(date);
				newUserToken.setRefreshTime(date);
				newUserToken.setIsValid(0);
				userTokenDao.insert(newUserToken);
			} else {// 有token就更新
				userToken.setToken(access_token);
				userToken.setRefreshTime(date);
				userTokenDao.update(userToken);
			}
			user.setUserToken(access_token);
		}
		return messageDao.getMessage(user);

	}
}
