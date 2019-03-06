package com.poc.chatbot.common.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;




public class RestMessage implements GenericMessage, GenericMessageMutator, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5653157223301911837L;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String returnCode = "";

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data = null;

    @JsonIgnore
    private boolean customeMessage = false;

    @Override
    public void setOK() {
        this.setReturnCode(OK);
    }

    @Override
    public void setNG() {
        this.setReturnCode(NG);
    }

    @Override
    public void enableCustomeMessage() {
        customeMessage = true;
    }

    @Override
    public void transformMessage(LocaleAwareMessageService service) {
        if(this.message != null && !this.message.equals("")) {
            this.message = service.getMessage(this.message);
        }
    }

    @Override
    public String getReturnCode() {
        return returnCode;
    }

    @Override
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean isCustomeMessage() {
        return customeMessage;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("RestMessage{")
                .append("returnCode='" + returnCode + '\'')
                .append(", message='" + message + '\'');

        if(data!=null) buffer.append(", data=" + data.toString());

        buffer.append(", customeMessage=" + customeMessage)
                .append('}');

        return buffer.toString();
    }
}
