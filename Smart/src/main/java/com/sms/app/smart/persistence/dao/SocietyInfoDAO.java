package com.sms.app.smart.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sms.app.smart.persistence.entities.SmSocietyInfo;
import com.sms.app.smart.persistence.repositories.SmSocietyInfoRepository;

@Component
public class SocietyInfoDAO {

	@Autowired
	private SmSocietyInfoRepository smSocietyInfoRepository;
	
	public SmSocietyInfo persistSocietyDetails(SmSocietyInfo smSocietyInfo) {
		SmSocietyInfo smSocietyInfoSaved = smSocietyInfoRepository.saveAndFlush(smSocietyInfo);
		return smSocietyInfoSaved;
	}
	
}
