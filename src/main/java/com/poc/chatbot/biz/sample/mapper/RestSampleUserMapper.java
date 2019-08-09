package com.poc.chatbot.biz.sample.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RestSampleUserMapper {

	
	public Integer selectBasicSampleMaxData();
	
	public Integer setCreateBasicSampleData(Map<String, Object> reqData);
	
	public Integer selectPartitionSampleMaxData();
	
	public Integer setCreatePartitionSampleData(Map<String, Object> reqData);
	
	
	
	
}
