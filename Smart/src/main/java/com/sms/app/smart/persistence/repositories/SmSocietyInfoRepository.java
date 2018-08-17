package com.sms.app.smart.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.app.smart.persistence.entities.SmSocietyInfo;

@Repository
public interface SmSocietyInfoRepository extends JpaRepository<SmSocietyInfo, Integer>{

	
	
}
