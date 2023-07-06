package com.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = "profitQuery",
query = "select f from Farmer f join f.ownedFarms owned where owned.profit > 200")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private int version;

    private String name;

    private int age;

    private boolean gender;

    private int experience;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Farm> ownedFarms;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Farm operatedFarm;

    public Farmer(String name, int age, boolean gender, int experience, List<Farm> ownedFarms, Farm operatedFarm) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.experience = experience;
        this.ownedFarms = ownedFarms;
        this.operatedFarm = operatedFarm;
    }

    public Farmer() {

    }

    @Override
    public String toString() {
        return this.name;
    }

    public List<Farm> getOwnedFarms() {
        return ownedFarms;
    }
}
