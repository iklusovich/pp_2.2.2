package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
   private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        cars.add(new Car("car1", 1, "white"));
        cars.add(new Car("car2", 2, "red"));
        cars.add(new Car("car3", 3, "blue"));
        cars.add(new Car("car4", 4, "black"));
        cars.add(new Car("car5", 5, "yellow"));

        return cars;
    }
}
