package com.poc.chatbot.common.exception;


public class UnAuthorizedException extends BaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8367362152696547061L;

	public UnAuthorizedException(String code, Object[] messages) {
		super(code, messages);
	}

}