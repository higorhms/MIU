package com.cars;

import com.cars.entities.Car;
import com.cars.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        Person driver = new Person(1, "Jack Driver");
        Person owner = new Person(2, "Jill Owner");
        Car car = new Car(1, "Renegade", "Jeep", 2023, 0, owner, driver);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarService");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(driver);
        em.persist(owner);
        em.persist(car);


        System.out.println("\nCar: " + car.getModel() +
                "\nDriver: " + car.getDriver().getName() +
                "\nOwner: " + car.getOwner().getName()
        );

        System.out.println("\nOwner car: " + owner.getCar().getModel());

        tx.commit();
        em.close();
        emf.close();
    }
}
