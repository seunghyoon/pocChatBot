package com.poc.chatbot.biz.sample.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface RestSampleUserService {

	public Map<String, Object> getRestSampleDataCreate(Map<String, Object> reqData);
	
	public Map<String, Object> getRestSampleDataCreatePartition(Map<String, Object> reqData);

}
