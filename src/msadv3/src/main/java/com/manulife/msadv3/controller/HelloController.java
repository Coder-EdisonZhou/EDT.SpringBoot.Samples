package com.manulife.msadv3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/thymeleaf")
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap map){
        // 在模板中读取host属性
        map.addAttribute("host", "http://edisonchou.cnblogs.com");
        // 返回模板文件的名称
        return "index";
    }
}
