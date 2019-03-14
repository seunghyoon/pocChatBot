package com.poc.chatbot.common.exception;

public class ResourceNotFoundException extends BaseException{

	private static final long serialVersionUID = -2511739733546408393L;
	
	
	public ResourceNotFoundException(String code, Object[] messages) {
		super(code, messages);
	}

}