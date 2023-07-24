package com.miu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("")
    public LocalDate getCurrentTime(){
       return LocalDate.now();
    }
}
