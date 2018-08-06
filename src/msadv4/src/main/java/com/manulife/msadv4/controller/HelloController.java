package com.manulife.msadv4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/// 注意：
/// 这里需要事先导入Thyemleaf模板，详见pom.xml文件
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello(ModelMap map){
        // 在模板中读取host属性
        map.addAttribute("host", "http://edisonchou.cnblogs.com");
        // 返回模板文件的名称
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
