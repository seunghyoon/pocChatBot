package com.poc.chatbot.biz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.chatbot.common.message.GenericMessage;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/sample")
@Slf4j
public class RestSampleUserController {
	
	@RequestMapping("/message")
    public void message(GenericMessage message, String code) {

        // ���� �׽�Ʈ
        if("1".equals(code)){
            throw new RuntimeException("CM000010");
        }

        Map<String, String> map = new HashMap<>();
        map.put("����", "�޹в� �� ����");
        map.put("����", "ä����");
        message.setMessage(code);
        message.setData(map);
    }
	
	@RequestMapping("/messageGenericMessage")
    public GenericMessage messageGenericMessage(GenericMessage message, String code) {

		Map<String, String> map = new HashMap<>();
        map.put("����", "�޹в� �� ����");
        map.put("����", "ä����");
        message.setMessage(code);
        message.setData(map);
        return message;
    }
}
