package com.entities;

import jakarta.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    private int price;
    private float weight;
    private int age;

    public Animal(int price, float weight, int age) {
        this.price = price;
        this.weight = weight;
        this.age = age;
    }

    public Animal() {

    }

    @Override
    public String toString() {
        return this.getClass().toString();
    }
}
