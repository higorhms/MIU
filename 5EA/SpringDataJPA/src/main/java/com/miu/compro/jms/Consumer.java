package com.miu.compro.jms;

import com.miu.compro.entities.Student;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "${springjms.cs544queue}")
    public void receive(Student message){
        System.out.println("Received message: " + message);
    }
}
