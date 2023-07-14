package main;

import entities.Car;
import entities.Game;
import entities.Person;
import entities.Vehicle;
import factories.VehicleFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import practices.CustomBeanPostProcessor;

@Configuration
//@Profile({"development" , "default"})
public class SpringConfig {

    @Bean(initMethod = "init")
    @Scope(value = "prototype")
    @Profile({"development", "default"})
    public Vehicle vehicle() throws Exception {
        Car car = this.vehiclesFactory();
        car.setYear(2019);
        return car;
    }

    @Bean(initMethod = "init")
    @Scope(value = "prototype")
    @Profile("production")
    public Vehicle vehicleProd() throws Exception {
        Car car = Car.getInstance("Car Prod");
        car.setYear(2019);
        return car;
    }

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean(name = "game", initMethod = "init")
    @Scope(value = "singleton")
    public Game game() throws Exception {
        return new Game(this.vehicle()){
            @Override
            public Vehicle getVehicle() throws Exception {
                return vehicle();
            }
        };
    }

    @Bean
    public CustomBeanPostProcessor customBeanPostProcessor(){
        return new CustomBeanPostProcessor();
    }

    @Bean
    public Car vehiclesFactory() throws Exception {
        return new VehicleFactory().getObject();
    }
}
