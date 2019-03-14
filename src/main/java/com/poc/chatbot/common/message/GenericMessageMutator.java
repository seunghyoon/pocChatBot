package com.poc.chatbot.common.message;

public interface GenericMessageMutator {
	
	public String getResponseCode();
	
	public boolean isCustomeMessage();
	
	public String getMessage();

	public Object getData();

	public String getReturnCode();
	
    public String getBizResCode();
    
    public String getTransactionId();
    
    public String getMaskServerIp();

    public Object getMessageDatas();

	public void transformMessage(LocaleAwareMessageService service);
	
	public String getServerTime();
	
	

}
