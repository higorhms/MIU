package com.entities;

public class Sheep extends Animal{

    private int wool;

    private boolean horns;

    public Sheep(int price, int weight, int age, int wool, boolean horns) {
        super(price, weight, age);
        this.horns = horns;
        this.wool = wool;
    }
}
