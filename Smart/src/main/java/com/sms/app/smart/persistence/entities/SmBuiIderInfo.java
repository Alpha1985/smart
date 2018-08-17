package com.sms.app.smart.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.EnableTransactionManagement;

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
	
	@OneToMany(mappedBy="builderInfo", cascade=CascadeType.ALL)
	//@Transient
	private List<SmSocietyInfo> societyList;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone_1")
	private String phone1;

	
	@Column(name="phone_2")
	private String phone2;
	
	@Column(name="email_id_1")
	private String emailId1;
	
	@Column(name="email_id_2")
	private String emailId2;
	
	
	
	public Integer getId() {
		return id;
	}
	public List<SmSocietyInfo> getSocietyList() {
		return societyList;
	}
	public void setSocietyList(List<SmSocietyInfo> societyList) {
		this.societyList = societyList;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmailId1() {
		return emailId1;
	}
	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	public String getEmailId2() {
		return emailId2;
	}
	public void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
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
