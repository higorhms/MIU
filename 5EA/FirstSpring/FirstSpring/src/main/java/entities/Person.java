package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

    @Autowired
    @Qualifier("vehicle")
    private Vehicle car;

//    public Car getCar() {
//        return car;
//    }

//
//    public void setCar(Car car) {
//        this.car = car;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }
}
