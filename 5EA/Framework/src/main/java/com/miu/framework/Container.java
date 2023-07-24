package com.miu.framework;

import com.miu.framework.annotations.*;
import com.miu.framework.interfaces.PreDestroy;
import com.miu.units.BigUnit;
import com.sun.tools.javac.Main;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Container {

    private Map<String, Object> context = new HashMap<>();

    public Container(){}

    private boolean isUnit(Object object){
        if(Objects.isNull(object)) return false;

        Class<?> objectClass = object.getClass();

        return this.isUnit(objectClass);
    }

    private boolean isUnit(Class<?> objectClass){
        return objectClass.isAnnotationPresent(Unit.class);
    }

    public <T> T create(Class<T> classType) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if(!isUnit(classType)) return null;
        Constructor constructor = classType.getDeclaredConstructor();
        constructor.setAccessible(true);

        T newUnit = (T) constructor.newInstance();

        for(Field field : classType.getDeclaredFields()){
            if(field.isAnnotationPresent(Inject.class)){
                field.setAccessible(true);
                Inject injectAnnotation = field.getAnnotation(Inject.class);
                field.set(newUnit, injectAnnotation.value());
            }
        }

        Unit unitAnnotation = classType.getAnnotation(Unit.class);


        for(Method method : classType.getMethods()){
            if(method.isAnnotationPresent(Invoke.class)){
                Invoke invokeAnnotation = method.getAnnotation(Invoke.class);
                if(invokeAnnotation.type() == InvokeType.POST_CONSTRUCT){
                    method.invoke(newUnit);
                }
            };
        }

        if(UnitType.CONTEXT == unitAnnotation.type()){
            this.context.put(classType.getName(), newUnit);
        }


        return newUnit;
     }

     public void close() throws InvocationTargetException, IllegalAccessException {
        for(Object object: this.context.values()){
            if(object instanceof PreDestroy) {
                ((PreDestroy) object).preDestroy();
            }


            for(Method method : object.getClass().getMethods()){
                if(method.isAnnotationPresent(Invoke.class)){
                    Invoke invokeAnnotation = method.getAnnotation(Invoke.class);
                    if(invokeAnnotation.type() == InvokeType.PRE_DESTROY){
                        method.invoke(object);
                    }
                };
            }
        }
        this.context.clear();
     }


     public <T> T getProxy(Class<T> classType){
        return ProxyCreator.getInstance(classType);
     }

     public void createClass() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
         FileWriter classWriter = new FileWriter("RuntimeClass.java", false);

         // write a class
         classWriter.write("public class RuntimeClass{");
         classWriter.write("public void hello(){");
         classWriter.write("System.out.println(\"Hello Hello Hello Hello!!\");");
         classWriter.write("}");
         classWriter.write("}");
         classWriter.flush();
         classWriter.close();

         //compile the class
         String[] sources = {"RuntimeClass.java"};
         Main.compile(sources);


         // run the class
         File currentDir = new File("./");
         URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{currentDir.toURI().toURL()});
         Class RuntimeClass = urlClassLoader.loadClass("RuntimeClass");
         Object RuntimeObject = RuntimeClass.newInstance();
         Class params[] = {};
         Method hello = RuntimeClass.getDeclaredMethod("hello", params);
         Object objectParams[] = {};
         hello.invoke(RuntimeObject, objectParams);
    }

}
