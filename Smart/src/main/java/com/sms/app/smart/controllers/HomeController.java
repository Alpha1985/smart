package com.sms.app.smart.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.app.smart.SmartAppStarter;
import com.sms.app.smart.constants.AppConstant;
import com.sms.app.smart.persistence.dao.BuilderInfoDAO;
import com.sms.app.smart.service.BuilderInfoService;
import com.sms.app.smart.service.SocietyManagementService;


@Controller
public class HomeController {
	
	private static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@Autowired
	private BuilderInfoService builderInfoService;
	
	@Autowired
	private SocietyManagementService societyManagementService;

	@RequestMapping(path=AppConstant.HOMEURL, method={RequestMethod.GET, RequestMethod.POST})
	public String getHomePage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("==== Inside HomePage ====");
		societyManagementService.getSocietyInfoFromBuilderDetails();
		return "index";
	}
	
}
