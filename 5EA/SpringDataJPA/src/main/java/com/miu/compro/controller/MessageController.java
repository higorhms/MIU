package com.miu.compro.controller;

import com.miu.compro.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private Producer producer;

    @Autowired
    public MessageController(Producer producer){
        this.producer = producer;
    }

    @GetMapping("/messages/{message}")
    public void sendMessage(@PathVariable String message){
        producer.send(message);
    }
}
