package org.fkit.hrm.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fkit.hrm.dao.stock.UserTokenDao;
import org.fkit.hrm.domain.stock.Message;
import org.fkit.hrm.domain.stock.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 判断用户权限的Spring MVC的拦截器
 */
public class JsonAuthorizedInterceptor implements HandlerInterceptor {
	private Logger logger = LogManager.getLogger(JsonAuthorizedInterceptor.class);
	@Autowired
	private Message<Object> message;
	@Autowired
	private UserTokenDao userTokenDao;
	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = { "/loginForm", "/login", "/404.html" };

	/**
	 * 该方法需要preHandle方法的返回值为true时才会执行。 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}

	/**
	 * 这个方法在preHandle方法返回值为true的时候才会执行。 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {

	}

	/**
	 * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
	 * 当preHandle的返回值为false的时候整个请求就结束了。
	 * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/** 默认用户没有登录 */
		boolean flag = false;
		/** 获得请求的ServletPath */
		String servletPath = request.getServletPath();
		/** 判断请求是否需要拦截 */
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				flag = true;
				break;
			}
		}
		/** 拦截请求 */
		if (!flag) {
			/** 1.获取session中的用户 */
			String token = request.getParameter("token");
			/** 2.判断用户是否已经登录 */
			UserToken newUserToken = new UserToken();
			newUserToken.setToken(token);
			UserToken userToken = userTokenDao.getUserTokenDetails(newUserToken);
			if (token == null || token == "" && userToken == null) {// token不存在
				ObjectMapper objectMapper = new ObjectMapper();
				message.clean();
				message.setCode(1003);
				message.setMsg("用户未登录！");
				String userJsonStr = objectMapper.writeValueAsString(message);// 返回字符串，输出
				returnJson(response, userJsonStr);
				return flag;
			} else {// 更新Token
				userToken.setRefreshTime(new Date(Calendar.getInstance().getTimeInMillis()));
				userTokenDao.update(userToken);
				flag = true;
			}
		}
		return flag;
	}

	private void returnJson(HttpServletResponse response, String json) throws Exception {
		PrintWriter writer = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			writer = response.getWriter();
			writer.print(json);
		} catch (IOException e) {
			logger.error("response error", e);
		} finally {
			if (writer != null)
				writer.close();
		}
	}
}
