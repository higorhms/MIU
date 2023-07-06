package main;

import entities.Car;
import entities.Game;
import entities.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(initMethod = "init")
    public Vehicle vehicle(){
        Car car = new Car("Renegade");
        car.setYear(2019);
        return car;
    }

    @Bean(name = "game")
    public Game game(){
        return new Game(this.vehicle());
    }
}
