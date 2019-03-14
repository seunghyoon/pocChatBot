package com.poc.chatbot.common.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.poc.chatbot.common.Const;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpServletUtil {
	
	
	public static String getClientIpAddress(){
		HttpServletRequest request = getHttpServletRequest();
		String ip = request.getHeader("X-FORWARDED-FOR");
		
		if(ip == null){			
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null){			
			ip = request.getHeader("NS-CLIENT-IP");
		}
		if(ip == null){			
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null){
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static String getTransationId(){
		String transationId = "";
		try{
			transationId = (String) RequestContextHolder.getRequestAttributes().getAttribute(Const.TRANSATION_ID, RequestAttributes.SCOPE_REQUEST);
    	}catch(Exception e){
    		log.trace(e.getMessage(), e);
    	}
		return transationId;
	}
	
	public static String getRequestUrI(){
		String url = "";
		try{
			url = getHttpServletRequest().getRequestURL().toString().replaceFirst(getHttpServletRequest().getContextPath(), "");
    	}catch(Exception e){
    		log.trace(e.getMessage(), e);
    	}
		return url;
	}
	
	public static HttpServletRequest getHttpServletRequest(){
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	
	public static String getUserAgent(){
		String userAgent = "";
		try{
			userAgent = getHttpServletRequest().getHeader("user-agent");
    	}catch(Exception e){
    		log.trace(e.getMessage(), e);
    	}
		return userAgent;
		
	}
	
	public static Integer getHttpStatusCode(){
		return (Integer) getHttpServletRequest().getAttribute("javax.servlet.error.status_code");
	}

	public static String getRequestForwardUri(){
		return (String) getHttpServletRequest().getAttribute("javax.servlet.forward.request_uri");
	}
	
	
	public static HttpSession getHttpSession(){
		HttpSession session = null;
		try{
			session = getHttpServletRequest().getSession();
    	}catch(Exception e){
    		log.trace(e.getMessage(), e);
    	}
		return session;
	}
	
}
