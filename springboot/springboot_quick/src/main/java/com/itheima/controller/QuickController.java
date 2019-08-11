package com.itheima.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@ConfigurationProperties(prefix = "person")
public class QuickController {

    private String name;
    private String age;

    @RequestMapping("/quick")
//    @ResponseBody
    public String quick(){
        return "name:" + name + ",age=" + age ;
//        return "Hello SpringBoot!!!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
