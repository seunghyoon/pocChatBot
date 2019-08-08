package com.poc.chatbot.biz.sample.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RestSampleUserMapper {

	
	public int setCreateBasicSampleData(Map<String, Object> reqData);
	
	public int setCreatePartitionSampleData(Map<String, Object> reqData);

	
	
}
