package entities;

public class Game {
    private Vehicle vehicle;

    public Game(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void start() {
        this.vehicle.move();
    }

    @Override
    public String toString() {
        return "Game{" +
                "vehicle=" + vehicle +
                '}';
    }
}
