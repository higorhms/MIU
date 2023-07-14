package edu.miu.cs.cs544.najeeb.config;

import edu.miu.cs.cs544.najeeb.exam2.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Proxy;
import java.time.DayOfWeek;

@Configuration
@Profile({"development", "default"})
public class SpringConfigDev {

    @Bean
    @Scope(value = "prototype")
    public DBService dbService(){
        DBService dbService = new DBService();
        dbService.setUrl("development");
        dbService.setUsername("jill");
        dbService.setPassword("123");
        return dbService;
    }

    @Bean
    @Scope(value = "singleton")
    public AIService aiService(){
        return new AIService();
    }

    @Bean
    @Scope(value = "singleton")
    public SMSService smsService(){
        return new SMSService(this.verizon());
    }

    @Bean
    public Verizon verizon(){
        return new Verizon(3, "jill");
    }

    @Bean
    public DayChecker dayChecker(){
        return new DayChecker(DayOfWeek.SUNDAY);
    }

    @Bean
    @Scope(value = "prototype")
    public Token token(){
        return new Token();
    }

    @Bean
    public Logger logger(){
        return new Logger("database");
    }

    @Bean LoggerAspect loggerAspect(){
        return new LoggerAspect();
    }

    @Bean
    public ProxyFactoryBean dbServiceProxy(){
        String[] interceptors = {"loggerAspect"};
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(dbService());
        proxyFactoryBean.setInterceptorNames(interceptors);
        return proxyFactoryBean;
    }

    @Bean
    public ProxyFactoryBean aiServiceProxy(){
        String[] interceptors = {"loggerAspect"};
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(aiService());
        proxyFactoryBean.setInterceptorNames(interceptors);
        return proxyFactoryBean;
    }

    @Bean
    public DayCheckerAspect dayCheckerAspect(){
        return new DayCheckerAspect();
    }

    @Bean
    public ProxyFactoryBean smsServiceProxy(){
        String[] interceptors = {"dayCheckerAspect"};
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(smsService());
        proxyFactoryBean.setInterceptorNames(interceptors);
        return proxyFactoryBean;
    }
}
