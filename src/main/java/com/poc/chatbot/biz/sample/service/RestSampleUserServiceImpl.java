package com.poc.chatbot.biz.sample.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.chatbot.biz.sample.mapper.RestSampleUserMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RestSampleUserServiceImpl implements RestSampleUserService{
	
	@Autowired
	private RestSampleUserMapper restSampleUserMapper;
	
	@Override
	public Map<String, Object> getRestSampleUserCreate(Map<String, Object> reqData) {
		log.info("RestSampleUserServiceImpl.getRestSampleUserCreate(), reqData : {}", reqData);
		restSampleUserMapper.setCreateBasicSampleData(reqData);
		return null;
	}

	@Override
	public Map<String, Object> getRestSampleUserCreatePartition(Map<String, Object> reqData) {
		log.info("RestSampleUserServiceImpl.getRestSampleUserCreatePartition(), reqData : {}", reqData);
		restSampleUserMapper.setCreatePartitionSampleData(reqData);
		return null;
	}

}
