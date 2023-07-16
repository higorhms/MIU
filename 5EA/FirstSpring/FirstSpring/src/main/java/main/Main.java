package main;

import entities.Game;
import entities.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        //environment
//        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
//        applicationContext.load("config*.xml");
//        applicationContext.refresh();
        //environment

//        Game game = ac.getBean("game", Game.class);
        Person person = ac.getBean("person", Person.class);


//        System.out.println(game);
        System.out.println(person);
    }
}