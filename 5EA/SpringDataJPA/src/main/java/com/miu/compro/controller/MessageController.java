package com.miu.compro.controller;

import com.miu.compro.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MessageController {

    private Producer producer;

    private MessageSource messageSource;

    @Autowired
    public MessageController(Producer producer, MessageSource messageSource){
        this.producer = producer;
        this.messageSource = messageSource;
    }

    @GetMapping("/messages/{message}")
    public void sendMessage(@PathVariable String message){
        producer.send(message);
    }

    @GetMapping("/")
    public String greet(Locale locale) {
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
