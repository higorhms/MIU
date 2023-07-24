package com.miu;

import com.miu.framework.Container;
import com.miu.framework.interfaces.UnitRepository;
import com.miu.units.BigUnit;
import com.miu.units.BigUnitRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        System.out.println("APP Start");
        try {
            Container container = new Container();
            BigUnit unit = container.create(BigUnit.class);
            System.out.println(unit);
            System.out.println("-----------------");
            BigUnitRepository bigUnitRepository = container.getProxy(BigUnitRepository.class);
            bigUnitRepository.method();
            System.out.println("-----------------");
            container.createClass();
        } catch (Exception e) {
            throw e;
        }

        System.out.println("APP End");
    }
}