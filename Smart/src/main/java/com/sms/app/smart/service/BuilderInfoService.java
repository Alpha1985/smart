package com.sms.app.smart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.app.smart.persistence.dao.BuilderInfoDAO;
import com.sms.app.smart.persistence.entities.SmBuiIderInfo;

@Service
public class BuilderInfoService {
	
	@Value("${app.name}")
	private String appName;
	
	@Autowired
	private BuilderInfoDAO builderInfoDAO;
	
	public void getUserInfo() {
		System.out.println("App Info:: "+appName);
	}
	
	@Transactional
	public void saveBuilderInfo() {
		List<SmBuiIderInfo> builderList = new ArrayList<>();
		SmBuiIderInfo builder1 = new SmBuiIderInfo();
		builder1.setName("Torino");
		SmBuiIderInfo builder2 = new SmBuiIderInfo();
		builder2.setName("GK Builders");
		builderList.add(builder1);
		builderList.add(builder2);
		builderInfoDAO.insertBuiIderInfo(builderList);
	}
	
	public void fetchBuiIderDetails() {
		builderInfoDAO.fetchBuiIderDetails(952);
	}
	@Transactional
	public void persistBuilderDetails() {
		SmBuiIderInfo  smBuiIderInfo = new SmBuiIderInfo();
		smBuiIderInfo.setName("Kalpatru");
		
		builderInfoDAO.persistBuilderDetails(smBuiIderInfo);
		
	}
	
	public void queryBuilderDetails() {
		builderInfoDAO.queryBuilderDetails();
	}
	
	@Transactional
	public void updateBuilderDetails() {
		builderInfoDAO.updateBuilderDetails();
	}
	

}
