package com.miu.controller;

import com.miu.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/message")
public class MessageController {

    private Producer producer;

    private MessageSource messageSource;

    @Autowired
    public MessageController(Producer producer, MessageSource messageSource){
        this.producer = producer;
        this.messageSource = messageSource;
    }

    @GetMapping("")
    public void sendMessage(@RequestParam String message, Locale locale){
//        Not working properly
//        this.producer.send(messageSource.getMessage("${message.greeting}", null, locale));

        this.producer.send(message);
    }
}
