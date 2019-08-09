package com.poc.chatbot.biz.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.chatbot.biz.sample.service.RestSampleUserService;
import com.poc.chatbot.common.message.GenericMessage;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/sample")
@Slf4j
public class RestSampleUserController {
	
	@Autowired
	RestSampleUserService restSampleUserService;
	
	
	@RequestMapping("/message")
    public void message(GenericMessage message, String code) {

		// 예외 테스트
        if("1".equals(code)){
            throw new RuntimeException("CM000010");
        }

        Map<String, String> map = new HashMap<>();
        map.put("dataCode", "CM000010");
        map.put("dataMessage", "테스트");
        message.setMessage(code);
        message.setData(map);
    }
	
	@RequestMapping(value = "/messageGenericMessage",  
			method= {RequestMethod.GET, RequestMethod.POST}, 
			produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GenericMessage messageGenericMessage(GenericMessage message, String code) {
		Map<String, String> map = new HashMap<>();
        map.put("dataCode", "CM000010");
        map.put("dataMessage", "테스트");
        log.debug("GenericMessage map {}" , map);

        message.setMessage(code);
        message.setData(map);
        log.debug("GenericMessage {}" , message);
        return message;
    }
	
	@RequestMapping(value = "/createBasicDataTest",  
			method= {RequestMethod.GET, RequestMethod.POST}, 
			produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GenericMessage createBasicDataTest(GenericMessage message, @RequestParam Map<String, Object> reqData) {
        log.debug("RestSampleUserController.createBasicDataTest(), reqData {}", reqData);
		message.setData(restSampleUserService.getRestSampleDataCreate(reqData));
		message.setMessage("CM000010");
		return message;
    }
	@RequestMapping(value = "/createPartitionDataTest",  
			method= {RequestMethod.GET, RequestMethod.POST}, 
			produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GenericMessage createPartitionDataTest(GenericMessage message, @RequestParam Map<String, Object> reqData) {
        log.debug("RestSampleUserController.createBasicDataTest(), reqData {}", reqData);
		message.setData(restSampleUserService.getRestSampleDataCreatePartition(reqData));
		message.setMessage("CM000010");
		return message;
    }
}
