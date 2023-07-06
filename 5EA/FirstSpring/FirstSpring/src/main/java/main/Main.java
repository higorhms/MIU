package main;

import entities.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);


        Object game = ac.getBean("game");


        System.out.println(game);
    }
}