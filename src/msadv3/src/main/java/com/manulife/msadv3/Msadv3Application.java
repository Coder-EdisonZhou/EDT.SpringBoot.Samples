package com.manulife.msadv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Msadv3Application {

	/// 此示例主要演示以下内容：
	/// 1.静态资源(比如图片导入/resources/static)的引入
	/// 2.Thymeleaf模板的使用
	/// 3.Thymeleaf模板的默认参数设置(application.properties)
	/// 4.Swagger2的引入实现API接口文档
	/// 5.统一异常处理(GlobalExceptionHandler)
	public static void main(String[] args) {
		SpringApplication.run(Msadv3Application.class, args);
	}
}
