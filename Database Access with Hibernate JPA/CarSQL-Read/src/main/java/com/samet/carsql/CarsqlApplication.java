package com.samet.carsql;

import com.samet.carsql.dao.CarDAO;
import com.samet.carsql.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsqlApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(CarDAO carDAO){
		return  runner ->{
			//readCar(carDAO);
			//readAllCar(carDAO);
			readCarByName(carDAO);
		};

	}

	private void readCarByName(CarDAO carDAO) {
		List<Car> myCar=carDAO.findByName("BMW");

		for(Car car:myCar){
			System.out.println(car);
		}
	}

	private void readAllCar(CarDAO carDAO) {
		List<Car> myList = carDAO.findAll();


		//display the results
		for(Car car : myList){
			System.out.println(car +"\n");
		}
	}

	private void readCar(CarDAO carDAO) {

		//display id of saved student
		int theId =1;
		System.out.println("Saved Student : Generated id : " + theId);

		//retrieve studentbased on id
		System.out.println("Retrieving  student with id : " +theId);
		Car car = carDAO.findById(theId);


		//display student
		System.out.println("Found my student : " + car);
	}


}
