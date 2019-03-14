package com.poc.chatbot.common.message;

import com.poc.chatbot.common.Const;
import com.poc.chatbot.common.exception.handler.ModelAndViewError;
import com.poc.chatbot.common.utils.DateUtil;
import com.poc.chatbot.common.utils.HttpServletUtil;
import com.poc.chatbot.common.utils.SystemInfoUtil;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class RestControllerMessageAdvice implements ResponseBodyAdvice<Object> {


    @Autowired
    private LocaleAwareMessageService messageService;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> messageConverter,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
    	log.debug("RestControllerMessageAdvice.beforeBodyWrite() => body : {} ", body);
		log.debug("RestControllerMessageAdvice.beforeBodyWrite() => body instanceof GenericMessage : {} ", body instanceof GenericMessage);
		log.debug("RestControllerMessageAdvice.beforeBodyWrite() => body instanceof ModelAndViewError : {} ", body instanceof ModelAndViewError);
        GenericMessage message = null;

        if(body instanceof GenericMessage) {
            message = (GenericMessage) body;
        }else{
            message = (GenericMessage) RequestContextHolder.getRequestAttributes().getAttribute(Const.GENERIC_MESSAGE, RequestAttributes.SCOPE_REQUEST);
            if(body!=null){
                message.setData(body);
            }
        }
        message.setBizResCode(((GenericMessageMutator) message).getBizResCode());
		message.setServerTime(DateUtil.getNowLocalDateTime(DateUtil.PATTERN_SERVER_TIME_A));
		message.setTransactionId(HttpServletUtil.getTransationId());
		message.setMaskServerIp(SystemInfoUtil.getHostAddress());
        
        if(!((GenericMessageMutator) message).isCustomeMessage()){
            ((GenericMessageMutator) message).transformMessage(messageService);
        }

        log.debug("RestControllerMessageAdvice.beforeBodyWrite End {}", message);


        return message;
    }

}
