package com.entities;

import jakarta.persistence.*;

@Entity
public class Sheep extends Animal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    private int wool;

    private boolean horns;

    public Sheep(int price, int weight, int age, int wool, boolean horns) {
        super(price, weight, age);
        this.horns = horns;
        this.wool = wool;
    }

    public Sheep() {

    }
}
