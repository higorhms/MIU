package main;

import entities.Car;
import entities.Game;
import entities.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Vehicle vehicle(){
        return new Car();
    }

    @Bean
    public Game game(){
        return new Game(this.vehicle());
    }
}
