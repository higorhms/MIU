package edu.miu.cs.cs544.najeeb.exam2;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class DayCheckerAspect implements MethodBeforeAdvice {

    @Autowired
    private DayChecker dayChecker;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if(!dayChecker.isTodayAuthorized()) throw new RuntimeException("Illegal day");
    }
}
