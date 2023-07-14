package factories;

import entities.Car;
import org.springframework.beans.factory.FactoryBean;

public class VehicleFactory implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        return Car.getInstance("Through Factory");
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }
}
