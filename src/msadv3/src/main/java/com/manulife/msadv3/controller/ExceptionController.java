package com.manulife.msadv3.controller;

import com.manulife.msadv3.util.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exception")
public class ExceptionController {
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("Hello Exception!");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("Hello Exception222!");
    }
}
