package com.miu.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "${springjms.cs544queue}")
    public void receive(String message){
        System.out.println(message);
    }
}
