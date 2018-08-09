package com.manulife.msadv7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Msadv7Application {

    /*
     * 此示例主要演示以下内容：
     * 1. 整合MyBatis
     * 2. MyBatis传参方式 => 使用@Param, Map 或 对象
     * 3. MyBatis增删改查单元测试示例
     * 4. 返回结果的绑定 => 使用@Results和@Result注解进行包装
     */
    public static void main(String[] args) {
        SpringApplication.run(Msadv7Application.class, args);
    }
}
