package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorld {
    private ResourceBundleMessageSource messageSource;

    public HelloWorld(@Autowired ResourceBundleMessageSource messageSource){
        this.messageSource = messageSource;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message", null, locale);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/hello/{name}")
    public String helloPerson(@PathVariable String name){
        return "Hello " + name;
    }
}
