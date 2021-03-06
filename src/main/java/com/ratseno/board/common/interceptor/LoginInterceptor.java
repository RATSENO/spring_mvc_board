package com.ratseno.board.common.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mysql.cj.api.Session;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberLoginRes = modelMap.get("memberLoginRes");
		
		if(memberLoginRes != null) {
			logger.info("new Login");
			session.setAttribute("LOGIN", memberLoginRes);
			Object dest = session.getAttribute("dest");
			if(request.getParameter("user_cookie") != null) {
				logger.info("자동 로그인 체크함");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60);//1분
				response.addCookie(loginCookie);
			}

			response.sendRedirect("/main/page");
		}else {
			response.sendRedirect("/member/login/page");
		}


	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LOGIN")!= null) {
			logger.info("clear login");
			session.removeAttribute("LOGIN");
		}

		return true;
	}

}
