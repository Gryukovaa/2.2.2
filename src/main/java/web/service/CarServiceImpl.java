package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars = Arrays.asList(new Car("bmv", 250, "black"),
            new Car("renault", 170, "yellow"),
            new Car("lada", 120, "red"),
            new Car("opel", 160, "white"),
            new Car("porches", 280, "green"));

    @Override
    public List<Car> getCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public int getLengthCarList(List<Car> cars) {
        return cars.size();
    }


}


