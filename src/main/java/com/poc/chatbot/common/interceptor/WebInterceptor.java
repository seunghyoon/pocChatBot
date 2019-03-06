package com.poc.chatbot.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
		logger.debug("WebInterceptor.afterCompletion()");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView exception) throws Exception {
		logger.debug("WebInterceptor.postHandle()");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object exception)
			throws Exception {

		String contextPath = request.getContextPath();

		String uri = request.getRequestURI().replaceAll(contextPath, "");

		String queryString = request.getQueryString();

		logger.debug("WebInterceptor.preHandle() contextPath = {} " , contextPath);
		logger.debug("WebInterceptor.preHandle() uri = {} " , uri);
		logger.debug("WebInterceptor.preHandle() queryString = {} " , queryString);

		return true;
	}

}
