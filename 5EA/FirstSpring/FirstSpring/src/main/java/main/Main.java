package main;

import entities.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        //environment
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("config*.xml");
        applicationContext.refresh();
        //environment

        Object game = ac.getBean("game");


        System.out.println(game);
    }
}