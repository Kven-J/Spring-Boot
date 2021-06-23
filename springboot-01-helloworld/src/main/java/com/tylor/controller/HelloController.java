package com.tylor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hi")
public class HelloController {

    @RequestMapping("/hello")
    public @ResponseBody String hello(){
        return "HelloWorld!";
    }

}
