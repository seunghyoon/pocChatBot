package com.poc.chatbot.common.message;


public interface GenericMessage {
	
    String SUCCESS = "SUCCESS";

    String FAILE = "FAILE";
    
    public void setResponseCode(String responseCode);
    
    public void setSUCCESS();

    public void setFAILE();

    public void enableCustomeMessage();

    public void setMessage(String message);

    public void setData(Object data);

    public void setReturnCode(String returnCode);
    
    public void setBizResCode(String bizResCode);
    
    public void setTransactionId(String transactionId);
    
    public void setMaskServerIp(String maskServerIp);
    
    public void setMessageDatas(Object[] messageDatas);
    
    public void setServerTime(String serverTime);
    
}