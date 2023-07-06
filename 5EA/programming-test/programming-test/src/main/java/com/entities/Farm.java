package com.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Version
    private int version;

    private int size;
    private int cost;

    private int profit;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Animal> liveStock = new ArrayList<>();

    @OneToOne(mappedBy = "operatedFarm")
    private Farmer operator;

    public Farm(String name, int size, int cost, int profit, List<Animal> liveStock) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.liveStock = liveStock;
        this.profit = profit;
    }

    public Farm() {

    }

    public List<Animal> getLiveStock() {
        return liveStock;
    }
}
