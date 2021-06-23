package com.tylor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPages {

    @RequestMapping("")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/views/{level}/{no}")
    public String levelPage(@PathVariable("level") String level, @PathVariable("no") Integer no) {
        String page = "views/" + level + "/" +String.valueOf(no);
        System.out.println(page);
        return page;
    }

}
