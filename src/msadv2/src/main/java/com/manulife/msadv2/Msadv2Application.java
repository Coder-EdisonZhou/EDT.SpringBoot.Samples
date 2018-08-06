package com.manulife.msadv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Msadv2Application {

    /// 此示例主要演示以下内容：
    /// 1.一个分层的CRUD实例(Controller=>Service=>Repository)
    /// 2.针对RESTful接口的单元测试
    /// 3.针对Service接口的单元测试
    /// 4.使用Mock框架的单元测试
    public static void main(String[] args) {
        // spring boot 启动核心入口
        SpringApplication.run(Msadv2Application.class, args);
    }
}
