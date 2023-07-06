package week1practice;

import jakarta.persistence.Entity;

public class Main {
    public static void main(String[] args) {
        PersistenceService ps = new PersistenceService();

        Game leagueOfLegends = new Game("League of Legends");
        Game dota = new Game("Dota");
        Game fortnite = new Game("Fornite");
        Player jack = new Player("Jack");
        Player jill = new Player("Jill");

        jack.addGame(leagueOfLegends);
        jill.addGame(leagueOfLegends);
        jill.addGame(dota);
        jill.addGame(fortnite);

        leagueOfLegends.setAdmin(jack);
        leagueOfLegends.addPlayer(jack);
        dota.addPlayer(jill);

        ps.save(jack);
        ps.save(dota);
        ps.save(fortnite);

        System.out.println("\n");
        System.out.println("getAllGamesDynamicQuery: " + ps.getAllGamesDynamicQuery());
        System.out.println("getAllGamesNamedQuery: " + ps.getAllGamesNamedQuery());
        System.out.println("getAllGamesCriteriaAPI: " + ps.getAllGamesCriteriaAPI());
        System.out.println("\n");
        System.out.println("getAllGamesIfPlayerNameIsPlayingDynamic: " + ps.getAllGamesIfPlayerNameIsPlayingDynamic());
        System.out.println("getAllGamesIfPlayerNameIsPlayingNamed: " + ps.getAllGamesIfPlayerNameIsPlayingNamed());
        System.out.println("getAllGamesIfPlayerNameIsPlayingCriteria: " + ps.getAllGamesIfPlayerNameIsPlayingCriteria());
        System.out.println("\n");

    }
}
