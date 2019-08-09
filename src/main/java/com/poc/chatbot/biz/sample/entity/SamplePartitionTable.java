package com.poc.chatbot.biz.sample.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="SAMPLE_PARTITION_TABLE", schema="TEST")
public class SamplePartitionTable {
	
	@Id 
	@GeneratedValue
	private Integer id;
	
	private String data;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regData;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setRegData(Date regData) {
		this.regData = regData;
	}
	
	
}
