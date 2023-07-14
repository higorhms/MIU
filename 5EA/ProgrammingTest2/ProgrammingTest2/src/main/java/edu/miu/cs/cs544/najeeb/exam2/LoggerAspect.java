package edu.miu.cs.cs544.najeeb.exam2;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class LoggerAspect implements MethodBeforeAdvice
//        ,
//        AfterReturningAdvice
{
    @Autowired
    private Logger logger;

//    @Override
//    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
//        System.out.println("Higor");
//        this.logger.log();
//    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        this.logger.log();
    }
}
