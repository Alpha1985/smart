package com.sms.app.smart.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.app.smart.constants.AppConstant;
import com.sms.app.smart.persistence.dao.BuilderInfoDAO;
import com.sms.app.smart.service.BuilderInfoService;


@Controller
public class HomeController {
	
	@Autowired
	private BuilderInfoService builderInfoService;


	@RequestMapping(path=AppConstant.HOMEURL, method={RequestMethod.GET, RequestMethod.POST})
	public String getHomePage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("==== Inside HomePage ====");
		builderInfoService.fetchBuiIderDetails();
		return "index";
	}
	
}
