package com.samet.cardemo.rest;


import com.samet.cardemo.entity.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private List<Car> theCars;

    @PostConstruct
    public void loadData(){
        theCars = new ArrayList<>();
        theCars.add(new Car("BMW","Black"));
        theCars.add(new Car("Mercedes","White"));
        theCars.add(new Car("Audi","Gray"));

    }

    @GetMapping("/cars")
    public List<Car> getWorkers(){

        return theCars;
    }


    //path variablee
    @GetMapping("/cars/{carId}")
    public Car getWorker(@PathVariable int carId){
        return  theCars.get(carId);
    }
}
