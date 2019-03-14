package com.poc.chatbot.common.message;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestMessage implements GenericMessage, GenericMessageMutator, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6424741204213487371L;
	
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String returnCode = "";
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message = "";
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String bizResCode = null;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object[] messageDatas = null;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data = null;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String transactionId = null;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String maskServerIp = null;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String serverTime = "";
	
	@JsonIgnore
    private boolean customeMessage = false;
	
	
	@Override
	public boolean isCustomeMessage() {
		return customeMessage;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Object getData() {
		return data;
	}

	@Override
	public String getReturnCode() {
		return returnCode;
	}

	@Override
	public String getBizResCode() {
		return bizResCode;
	}

	@Override
	public String getTransactionId() {
		return transactionId;
	}

	@Override
	public String getMaskServerIp() {
		return maskServerIp;
	}

	@Override
	public Object[] getMessageDatas() {
		return messageDatas;
	}

	
	@Override
	public void setSUCCESS() {
		this.setReturnCode(SUCCESS);
		
	}

	@Override
	public void setFAILE() {
		this.setReturnCode(FAILE);
	}

	@Override
	public void enableCustomeMessage() {
		this.customeMessage = true;
		
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
		
	}

	@Override
	public void setData(Object data) {
		this.data = data;
		
	}

	@Override
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
		
	}

	@Override
	public void setBizResCode(String bizResCode) {
		this.bizResCode = bizResCode;
		
	}

	@Override
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		
	}

	@Override
	public void setMaskServerIp(String maskServerIp) {
		this.maskServerIp = maskServerIp;
		
	}

	@Override
	public void setMessageDatas(Object[] messageDatas) {
		this.messageDatas = messageDatas;
	}

	@Override
	public String getServerTime() {
		return serverTime;
	}

	@Override
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	@Override
	public void transformMessage(LocaleAwareMessageService service) {
		if (!StringUtils.isEmpty(this.bizResCode)) {
			this.message = service.getMessage(this.bizResCode, this.messageDatas);
		}
	}

}
