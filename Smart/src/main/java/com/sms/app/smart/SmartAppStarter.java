package com.sms.app.smart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SmartAppStarter {

	private static final Logger logger = LogManager.getLogger(SmartAppStarter.class);
	
	public static void main(String[] args) {
		logger.info("==== Starting Main App ====");
		SpringApplication springApp = new SpringApplication(SmartAppStarter.class);
		springApp.run(args);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySources() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
