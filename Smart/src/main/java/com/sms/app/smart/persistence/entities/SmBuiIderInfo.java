package com.sms.app.smart.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sm_builder_info")
public class SmBuiIderInfo implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5112940699845327349L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="builder_seq_gen")
	@SequenceGenerator(name="builder_seq_gen", sequenceName="SM_BUILDER_INFO_SEQ")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone_1")
	private String phone1;
	
	
	public Integer getId() {
		return id;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
