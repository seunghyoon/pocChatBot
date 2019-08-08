package com.poc.chatbot.biz.sample.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface RestSampleUserService {

	public Map<String, Object> getRestSampleUserCreate(Map<String, Object> reqData);
	
	public Map<String, Object> getRestSampleUserCreatePartition(Map<String, Object> reqData);

}
