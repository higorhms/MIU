package com.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @Version
    private int version;

    private int size;
    private int cost;

    private int liveStock;

    private List<Animal> stock = new ArrayList<>();

    public Farm(String name, int size, int cost, int liveStock, List<Animal> stock) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.liveStock = liveStock;
        this.stock = stock;
    }

    public Farm() {

    }
}
