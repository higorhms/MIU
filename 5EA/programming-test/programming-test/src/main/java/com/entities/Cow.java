package com.entities;

public class Cow extends Animal {
    private int milk;

    private String foodType;

    public Cow(int price, float weight, int age, int milk, String foodType) {
        super(price,weight,age);
        this.milk = milk;
        this.foodType = foodType;
    }
}
