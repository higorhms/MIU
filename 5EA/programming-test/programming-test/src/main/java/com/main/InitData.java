package com.main;

import com.entities.*;
import com.persistence.PersistenceService;

import java.util.ArrayList;
import java.util.List;

public class InitData {
    public static void CreateData() {
        //Cow constructor int price, int weight, int age, int milk, String foodtype
        Cow blackCow = new Cow(1500, 1200, 10, 6, "grass");
        Cow brownCow = new Cow(1600, 1250, 8, 8, "grass");
        //Sheep constructor int price, int weight, int age, int wool, boolean horns
        Sheep youngSheep = new Sheep(250, 50, 5, 10, false);
        Sheep blackSheep = new Sheep(350, 100, 12, 25, false);
        List<Animal> happyFarmLivestock = new ArrayList<Animal>();
        happyFarmLivestock.add(blackCow);
        happyFarmLivestock.add(brownCow);
        happyFarmLivestock.add(youngSheep);
        happyFarmLivestock.add(blackSheep);
        //Farm constrcutor String name, int size, int cost, int profit, List<Animal> livestock
        Farm happyFarm = new Farm("Happy Farm", 150, 500, 200, happyFarmLivestock);

        Cow youngCow = new Cow(800, 250, 2, 0, "grass");
        Sheep oldSheep = new Sheep(550, 400, 13, 35, true);
        List<Animal> organicFarmLivestock = new ArrayList<Animal>();
        organicFarmLivestock.add(youngCow);
        organicFarmLivestock.add(oldSheep);
        Farm organicFarm = new Farm("Organic Farm", 100, 750, 250, organicFarmLivestock);

        List<Farm> jackFarms = new ArrayList<Farm>();
        jackFarms.add(happyFarm);
        jackFarms.add(organicFarm);
        //Farmer constrcutor String name, int age, boolean gender, int experience, List<Farm> ownedFarms, Farm operatedFarm
        Farmer jack = new Farmer("Jack", 35, true, 10, jackFarms, happyFarm);

        Cow whiteCow = new Cow(1200, 1300, 15, 8, "corn");
        Cow yellowCow = new Cow(1300, 1100, 12, 6, "corn");
        //Sheep constructor int price, int weight, int age, int wool, boolean horns
        Sheep bigSheep = new Sheep(550, 200, 12, 25, true);
        Sheep flufySheep = new Sheep(350, 100, 12, 35, false);
        List<Animal> longFarmLivestock = new ArrayList<Animal>();
        longFarmLivestock.add(whiteCow);
        longFarmLivestock.add(yellowCow);
        longFarmLivestock.add(bigSheep);
        longFarmLivestock.add(flufySheep);
        //Farm constrcutor String name, int size, int cost, int profit, List<Animal> livestock
        Farm longFarm = new Farm("Long Farm", 250, 500, 200, longFarmLivestock);
        List<Farm> johnFarms = new ArrayList<Farm>();
        johnFarms.add(longFarm);
        Farmer john = new Farmer("John", 45, true, 20, johnFarms, longFarm);

        List<Farm> jillFarms = new ArrayList<Farm>();
        Farmer jill = new Farmer("Jill", 50, false, 25, jillFarms, organicFarm);

        //--------------------------------------------

        PersistenceService ps = new PersistenceService();
        ps.save(jill);
        ps.save(john);
        ps.save(jack);
    }
}