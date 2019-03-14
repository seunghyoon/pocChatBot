package com.poc.chatbot.common.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poc.chatbot.common.exception.ResourceNotFoundException;
import com.poc.chatbot.common.utils.HttpServletUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerErrorController implements ErrorController{
	
	private static final String ERROR_PATH = "/error";
	
	@RequestMapping(value = ERROR_PATH)
	public void error() {
		int httpStatusCode = HttpServletUtil.getHttpStatusCode();
		log.debug("CustomerErrorController.error httpStatusCode : {}", httpStatusCode);
		if(HttpStatus.NOT_FOUND.value() == httpStatusCode) {
			throw new ResourceNotFoundException("HTTP.ERROR.404", new Object[] {});
		}
	}
	
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
