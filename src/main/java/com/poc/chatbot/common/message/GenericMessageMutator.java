package com.poc.chatbot.common.message;

public interface GenericMessageMutator {

    boolean isCustomeMessage();

    Object getData();

    String getMessage();

    String getReturnCode();

    void transformMessage(LocaleAwareMessageService service);
}
