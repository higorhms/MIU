package week1practice;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "games")
@NamedQuery(name = "getAllGamesNamedQuery", query = "SELECT G FROM games G")
@NamedQuery(name = "getAllGamesIfPlayerNameIsPlayingNamed", query = "select g from games g join g.players p where p.name = 'jack'")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "gamesOwned", cascade = CascadeType.PERSIST)
    private List<Player> owners = new ArrayList<Player>();

    @OneToMany(mappedBy = "playing")
    private List<Player> players = new ArrayList<Player>();

    @OneToOne
    private  Player admin;

    public Game() {
    }

    public Game(String name) {
        this.name = name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
        player.setPlaying(this);
    }

    public void setAdmin(Player admin) {
        this.admin = admin;
    }

    public void addOwner(Player player){
        this.owners.add(player);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owners=" + owners +
                ", players=" + players +
                ", admin=" + admin +
                '}';
    }
}
