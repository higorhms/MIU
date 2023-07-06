package main;

import entities.Car;
import entities.Game;
import entities.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"development" , "default"})
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
