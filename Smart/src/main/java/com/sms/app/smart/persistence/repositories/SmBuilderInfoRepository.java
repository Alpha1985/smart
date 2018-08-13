package com.sms.app.smart.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.app.smart.persistence.entities.SmBuiIderInfo;

@Repository
public interface SmBuilderInfoRepository extends JpaRepository<SmBuiIderInfo, Long> {

}
