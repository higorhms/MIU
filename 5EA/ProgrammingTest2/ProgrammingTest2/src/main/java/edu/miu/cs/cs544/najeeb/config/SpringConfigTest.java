package edu.miu.cs.cs544.najeeb.config;

import edu.miu.cs.cs544.najeeb.exam2.*;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.time.DayOfWeek;

@Configuration
@Profile("testing")
public class SpringConfigTest {

    @Bean
    @Scope(value = "prototype")
    public DBService dbService(){
        DBService dbService = new DBService();
        dbService.setUrl("testing");
        dbService.setUsername("jim");
        dbService.setPassword("111");
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
        return new Verizon(10, "jim");
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
        return new Logger("file");
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
