package entities;

public abstract class Game {
    private Vehicle vehicle;

    public Game(Vehicle vehicle) {
//        System.out.println("Game constructor");
        this.vehicle = vehicle;
    }

    public Game() {
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

    public void init(){
        System.out.println("init game");
    }

    public abstract Vehicle getVehicle() throws Exception;
}
