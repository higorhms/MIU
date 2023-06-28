package com.cars.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
    @Id
    private int id;
    private String  model;
    private String  make;
    private int year;
    private int mileage;

    @OneToOne
    private Person owner;

    @OneToOne
    private Person driver;

    public Car(int id, String model, String make, int year, int mileage, Person owner, Person driver) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.owner = owner;
        owner.setCar(this);
        this.driver = driver;
    }

    public Car() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        String toString = "ID: " + this.id +
                "\nModel: " + this.model +
                "\nMake: " + this.make +
                "\nYear: " + this.year +
                "\nMileage: " + this.mileage +
                "\n";
        return toString;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }
}
