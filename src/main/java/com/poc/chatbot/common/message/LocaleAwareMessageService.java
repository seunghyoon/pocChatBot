package com.poc.chatbot.common.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@Component
public class LocaleAwareMessageService {

    @Autowired
    private MessageSource messageSource;

   public String getMessage(String code, Object[] messageDatas){
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}
