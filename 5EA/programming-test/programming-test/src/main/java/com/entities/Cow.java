package com.entities;

import jakarta.persistence.*;

@Entity
public class Cow extends Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    private int milk;

    private String foodType;

    public Cow(int price, float weight, int age, int milk, String foodType) {
        super(price,weight,age);
        this.milk = milk;
        this.foodType = foodType;
    }

    public Cow() {

    }

}
