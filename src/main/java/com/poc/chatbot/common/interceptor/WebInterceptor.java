package com.poc.chatbot.common.interceptor;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.poc.chatbot.common.Const;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class WebInterceptor implements HandlerInterceptor {


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
		log.debug("WebInterceptor.afterCompletion()");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView exception) throws Exception {
		log.debug("WebInterceptor.postHandle()");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object exception)
			throws Exception {

		String contextPath = request.getContextPath();

		String uri = request.getRequestURI().replaceAll(contextPath, "");

		String queryString = request.getQueryString();
		
		RequestContextHolder.getRequestAttributes().setAttribute(Const.TRANSATION_ID, UUID.randomUUID().toString(), RequestAttributes.SCOPE_REQUEST);

		log.debug("WebInterceptor.preHandle() contextPath : {} " , contextPath);
		log.debug("WebInterceptor.preHandle() uri : {} " , uri);
		log.debug("WebInterceptor.preHandle() queryString : {} " , queryString);

		return true;
	}

}
