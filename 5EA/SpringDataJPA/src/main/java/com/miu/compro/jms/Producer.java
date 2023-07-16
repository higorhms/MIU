package com.miu.compro.jms;

import com.miu.compro.entities.Student;
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
    public Producer (JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message){
        Student student = new Student();
        student.setName("Higor");
        student.setGpa(40);
        jmsTemplate.convertAndSend(queueName, student);
    }
}
