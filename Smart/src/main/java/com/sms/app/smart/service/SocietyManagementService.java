package com.sms.app.smart.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sms.app.smart.controllers.HomeController;
import com.sms.app.smart.persistence.dao.BuilderInfoDAO;
import com.sms.app.smart.persistence.dao.SocietyInfoDAO;
import com.sms.app.smart.persistence.entities.SmBuiIderInfo;
import com.sms.app.smart.persistence.entities.SmSocietyInfo;

@Service
public class SocietyManagementService {
	
	private static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@Autowired
	private SocietyInfoDAO societyInfoDAO;
	
	@Autowired
	private BuilderInfoDAO builderInfoDAO;
	
	@Transactional
	public void persistSocietyDetails() {
		logger.info("==== Inside persistSocietyDetails ====");
		SmBuiIderInfo smBuiIderInfo = builderInfoDAO.fetchBuiIderDetails(955);
		SmSocietyInfo smSocietyInfo = new SmSocietyInfo();
		smSocietyInfo.setBuilding("A-Wing");
		smSocietyInfo.setCity("Pune");
		smSocietyInfo.setLocality("Shivraj");
		smSocietyInfo.setPinCode("411017");
		smSocietyInfo.setSmBuiIderInfo(smBuiIderInfo);
		smSocietyInfo.setSocietyName("Orange County");
		smSocietyInfo.setState("Maharashtra");
		smSocietyInfo.setStreet("Chowk");
		smSocietyInfo.setTown("Pune");
		
		SmSocietyInfo smSocietyInfoSaved = societyInfoDAO.persistSocietyDetails(smSocietyInfo);
		logger.info("Society Info saved ID:: "+smSocietyInfoSaved.getId());
		
		
	}
	
	public List<SmSocietyInfo> getSocietyInfoFromBuilderDetails() {
		logger.info("==== Fetching society Details ====");
		SmBuiIderInfo smBuiIderInfo = builderInfoDAO.fetchBuiIderDetails(955);
		List<SmSocietyInfo> societyList = smBuiIderInfo.getSocietyList();
		if(!CollectionUtils.isEmpty(societyList)) {
			societyList.forEach(logger::info);
		}
		return societyList;
	}

}
