package com.poc.chatbot.common.exception;

public class BaseException extends RuntimeException{
	
	private static final long serialVersionUID = -3324817931455469171L;

	private String code;
	
	private Object[] messages;
	
	private Exception cause;
	
	public BaseException() {
		super();
	}
	
	public BaseException(String code, Object[] messages, Exception cause) {
		this.setCode(code);
		this.setMessages(messages);
		this.setCause(cause);
	}
	
	public BaseException(String code, Exception cause) {
		this.setCode(code);
		this.setCause(cause);
	}
	
	public BaseException(String code, Object[] messages) {
		this.setCode(code);
		this.setMessages(messages);
	}
	
	public BaseException(Exception cause) {
		this.setCause(cause);
	}
	
	public BaseException(String code) {
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getMessages() {
		return messages;
	}

	public void setMessages(Object[] messages) {
		this.messages = messages;
	}

	public Exception getCause() {
		return cause;
	}

	public void setCause(Exception cause) {
		this.cause = cause;
	}
	
}
