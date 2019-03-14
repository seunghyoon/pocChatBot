package com.poc.chatbot.common.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poc.chatbot.common.exception.BaseException;
import com.poc.chatbot.common.exception.BedRequestException;
import com.poc.chatbot.common.exception.NoContentException;
import com.poc.chatbot.common.exception.ResourceNotFoundException;
import com.poc.chatbot.common.message.GenericMessage;

import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	//@ResponseBody
	public <T> T handleResourceNotFoundException(GenericMessage messages, ResourceNotFoundException exception) {
		if(true) { //Ajax
			messages.setError();
			messages.setReturnCode(exception.getCode());
			messages.setMessageDatas(exception.getMessages());
		}else {
			
		}
		return null;
	}
	
	@ExceptionHandler(BedRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	//@ResponseBody
	public <T> T handleBedRequestException(GenericMessage messages, BedRequestException exception) {
		if(true) { //Ajax
			messages.setError();
			messages.setReturnCode(exception.getCode());
			messages.setMessageDatas(exception.getMessages());
		}else {
			
		}
		return null;
	}
	
	@ExceptionHandler(NoContentException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	//@ResponseBody
	public <T> T handleNoContentException(GenericMessage messages, NoContentException exception) {
		if(true) { //Ajax
			messages.setError();
			messages.setReturnCode(exception.getCode());
			messages.setMessageDatas(exception.getMessages());
		}else {
			
		}
		return null;
	}
	
	private void writeLog(BaseException exception) {
		log.error(exception.getCode(), exception.getMessages(), exception);
	}
}