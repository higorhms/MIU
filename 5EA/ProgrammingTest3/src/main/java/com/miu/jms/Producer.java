package com.miu.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private JmsTemplate jmsTemplate;

    @Value(value = "${springjms.cs544queue}")
    private String queueName;

    @Autowired
    public Producer(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message){
        this.jmsTemplate.convertAndSend(queueName, message);
    }
}
