package week1practice;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Game> gamesOwned = new ArrayList<Game>();

    @ManyToOne
    private Game playing;

    @OneToOne(mappedBy = "admin")
    private Game managing;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public void addGame(Game game){
        this.gamesOwned.add(game);
        game.addOwner(this);
    }

    public void setPlaying(Game playing) {
        this.playing = playing;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
