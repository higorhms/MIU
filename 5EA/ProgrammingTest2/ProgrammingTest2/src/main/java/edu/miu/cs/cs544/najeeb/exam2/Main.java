package edu.miu.cs.cs544.najeeb.exam2;

import edu.miu.cs.cs544.najeeb.config.SpringConfigDev;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("App start");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("edu.miu.cs.cs544.najeeb.config");
        applicationContext.refresh();

        DBService dbService= applicationContext.getBean("dbServiceProxy", DBService.class);
        AIService aiService= applicationContext.getBean("aiServiceProxy", AIService.class);
        SMSService smsService= applicationContext.getBean("smsServiceProxy", SMSService.class);

        try {
            dbService.connect();

            // This code should not be modified, but you should get it to work.
            dbService.persist("Hello World!");
            System.out.println(aiService.ask(aiService.getToken(), "Will I pass this course?"));
            smsService.sendMessage("Hello MIU!", "6414727000");
            smsService.sendMessage("I am a student.", "6414727000");
            smsService.sendMessage("I am interested in learning.", "6414727000");
            smsService.sendMessage("When is lunch?", "6414727000");
            smsService.sendMessage("Do you provide a shuttle service?", "6414727000");
            smsService.sendMessage("May I get a loan?", "6414727000");
            // End of code that cannot be modified
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("App end");
    }
}