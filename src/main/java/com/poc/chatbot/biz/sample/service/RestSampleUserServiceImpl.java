package com.poc.chatbot.biz.sample.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.chatbot.biz.sample.entity.SamplePartitionTable;
import com.poc.chatbot.biz.sample.mapper.RestSampleUserMapper;
import com.poc.chatbot.biz.sample.repository.SamplePartitionTableRepository;
import com.poc.chatbot.common.utils.StringUtil;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RestSampleUserServiceImpl implements RestSampleUserService{
	
	@Autowired
	private RestSampleUserMapper restSampleUserMapper;
	
	@Autowired
	private SamplePartitionTableRepository samplePartitionTableRepository;
	
	
	@Override
	@Transactional
	public Map<String, Object> getRestSampleDataCreate(Map<String, Object> reqData) {
		
		
		log.debug("RestSampleUserServiceImpl.getRestSampleUserCreate(), reqData : {}", reqData);
		Integer id = restSampleUserMapper.selectBasicSampleMaxData();
		log.debug("RestSampleUserServiceImpl.getRestSampleUserCreate(), id : {}", id);
		reqData.put("id", id);
		reqData.put("data", StringUtil.getStringBufferAppend(id.toString(), "_샘플 BASIC 데이터 입력"));
		log.debug("RestSampleUserServiceImpl.getRestSampleUserCreate(), reqData : {}", reqData);
		
		Integer creCnt = restSampleUserMapper.setCreateBasicSampleData(reqData);
		log.debug("RestSampleUserServiceImpl.getRestSampleUserCreate(), creCnt : {}", creCnt);
		return null;
	}
	
	@Override
	public Map<String, Object> getRestSampleDataCreatePartition(Map<String, Object> reqData) {

		
		log.info("RestSampleUserServiceImpl.getRestSampleUserCreatePartition(), reqData : {}", reqData);
		Integer id = restSampleUserMapper.selectPartitionSampleMaxData();
		log.info("RestSampleUserServiceImpl.getRestSampleUserCreatePartition(), id : {}", id);
		reqData.put("id", id);
		reqData.put("data", StringUtil.getStringBufferAppend(id.toString(), "_샘플 PARTITION 데이터 입력"));
		Integer creCnt = restSampleUserMapper.setCreatePartitionSampleData(reqData);
		log.info("RestSampleUserServiceImpl.getRestSampleUserCreatePartition(), creCnt : {}", creCnt);
		
		return null;
	}
	
	
	@Override
	public Map<String, Object> getRestJpaSampleDataCreatePartition(Map<String, Object> reqData) {
		
		log.info("RestSampleUserServiceImpl.getRestJpaSampleDataCreatePartition(), reqData : {}", reqData);

		SamplePartitionTable entity = new SamplePartitionTable();
		entity.setData("TEST JPA 입력 데이터");
		entity.setRegData(new Date());
		
		samplePartitionTableRepository.save(entity);
		
		
		return null;
	}
}
