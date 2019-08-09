package com.poc.chatbot.biz.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.chatbot.biz.sample.entity.SamplePartitionTable;

public interface SamplePartitionTableRepository extends JpaRepository<SamplePartitionTable, Integer> {

}
