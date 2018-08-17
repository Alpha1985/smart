package com.sms.app.smart.persistence.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SM_SOCIETY_INFO")
public class SmSocietyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5337633155626320182L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="society_seq_gen")
	@SequenceGenerator(name="society_seq_gen", sequenceName="SM_SOCIETY_INFO_SEQ")
	private Integer id;

	@Column(name="name")
	private String societyName;
	
	@Column(name="Street")
	private String street;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="building")
	private String building;
	
	@Column(name="city")
	private String city;
	
	@Column(name="town")
	private String town;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pinCode")
	private String pinCode;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="builder_id")
	private SmBuiIderInfo builderInfo;
	
	
	public SmBuiIderInfo getSmBuiIderInfo() {
		return builderInfo;
	}

	public void setSmBuiIderInfo(SmBuiIderInfo smBuiIderInfo) {
		this.builderInfo = smBuiIderInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "SmSocietyInfo [id=" + id + ", societyName=" + societyName + ", street=" + street + ", locality="
				+ locality + ", building=" + building + ", city=" + city + ", town=" + town + ", state=" + state
				+ ", pinCode=" + pinCode + ", builderInfo=" + builderInfo + "]";
	}

	
	
	
	
	
	
	

	
	
}
