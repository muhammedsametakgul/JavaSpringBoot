package com.samet.cardemo.rest;


import com.samet.cardemo.entity.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if((carId>=theCars.size()) || (carId<0)){
            throw new CarNotFoundException("ID not found - "+ carId);
        }

        return  theCars.get(carId);
    }

    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(CarNotFoundException err){

        //create car  error  response
        CarErrorResponse error = new CarErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(err.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        //return it
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    //add another exceptionhandler to catch all type
    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(Exception exception){

        //create car error response
        CarErrorResponse error = new CarErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
}
