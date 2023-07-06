package com.main;

import com.persistence.PersistenceService;

public class Main {

    public static void main(String[] args) {
        PersistenceService ps = new PersistenceService();
        InitData.CreateData();

        System.out.println("");
        System.out.println("Question 2 - Find all animals in the farm operated by jack");
        System.out.println(ps.findAllAnimalsInTheFarmOperatedByJack());
        System.out.println("");
        System.out.println("Question 3 - Write a Criteria API to find...");
//        System.out.println(ps.findAllCowsWeightingMoreThan1200InAFarmOfSizeLessThan300AcresAndTheOwnersAgeIsGreaterThan25());
        System.out.println("");
        System.out.println("Question 4 ");
        System.out.println(ps.findAllFarmersThatOwnAFarmThatReturnsMoreThan200Profits());
        System.out.println("");
        System.out.println("Question 5 - Print age of all farmers");
        System.out.println(ps.findAllAges());
    }
}
