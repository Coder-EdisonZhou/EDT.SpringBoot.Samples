package com.manulife.msadv5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Msadv5Application {

    /// 此示例主要演示以下内容：
    /// 1.多数据源配置(基于JdbcTemplate)
    /// 2.多数据源配置(基于Spring-Data-JPA)
    public static void main(String[] args) {
        SpringApplication.run(Msadv5Application.class, args);
    }
}
