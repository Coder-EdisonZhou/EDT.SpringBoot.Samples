package com.manulife.msadv12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Msadv12Application {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testLogLevel(){
		logger.debug("Logger Level : DEBUG");
		logger.info("Logger Level : INFO");
		logger.error("Logger Level : ERROR");

		return "";
	}

	/*
	 * 此示例主要演示以下内容：
	 * 1.使用log4j实现http请求日志存入MongoDB
	 * 2.动态修改日志级别（1.5.x新特性）
	 * 	查询日志级别设置：GET http://localhost:8080/loggers/com.manulife.msadv12
	 * 	更新日志级别设置：POST http://localhost:8080/loggers/com.manulife.msadv12
	 * 		POST BODY => { "configuredLevel" : "DEBUG" }
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv12Application.class, args);
	}
}
