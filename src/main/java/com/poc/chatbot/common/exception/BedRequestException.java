package com.poc.chatbot.common.exception;



public class BedRequestException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8649023314234075550L;

	public BedRequestException(String code, Object[] messages) {
		super(code, messages);
	}

}