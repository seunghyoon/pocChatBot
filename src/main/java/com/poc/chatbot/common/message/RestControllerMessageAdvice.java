package com.poc.chatbot.common.message;

import com.poc.chatbot.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(annotations = RestController.class)
public class RestControllerMessageAdvice implements ResponseBodyAdvice<Object> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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

        GenericMessage message = null;

        if(body instanceof GenericMessage) {
            message = (GenericMessage) body;
        }else{
            message = (GenericMessage) RequestContextHolder.getRequestAttributes().getAttribute(Const.GENERIC_MESSAGE, RequestAttributes.SCOPE_REQUEST);
            if(body!=null){
                message.setData(body);
            }
        }

        if(!((GenericMessageMutator) message).isCustomeMessage()){
            ((GenericMessageMutator) message).transformMessage(messageService);
        }

        logger.debug("RestControllerMessageAdvice.beforeBodyWrite(): {}", ((RestMessage) message).toString());


        return message;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestMessage> handleOtherExceptions(Exception ex, WebRequest request) {

        logger.debug("RestControllerMessageAdvice.handleOtherExceptions(): {}", ex.getMessage());
        ex.printStackTrace();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestMessage message = new RestMessage();
        message.setMessage(ex.getMessage());

        // 怨듯넻 硫붿떆吏� 泥섎━
        if(!((GenericMessageMutator) message).isCustomeMessage()){
            ((GenericMessageMutator) message).transformMessage(messageService);
        }

        return new ResponseEntity<>(message, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
