package com.samet.carsql;

import com.samet.carsql.dao.CarDAO;
import com.samet.carsql.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsqlApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(CarDAO carDAO){
		return  runner ->{
			//saveCar(carDAO);
			saveMultipleCar(carDAO);
		};

	}

	private void saveMultipleCar(CarDAO carDAO) {
		System.out.println(" CAR...........");
		//create car object
		Car tempCar1 = new Car("Mercedes",150000,"White");
		Car tempCar2= new Car("Audi",200000,"Red");
		Car tempCar3 = new Car("Toyota",50000,"Blue");

		System.out.println("Saving all cars...........");
		carDAO.save(tempCar1);
		carDAO.save(tempCar2);
		carDAO.save(tempCar3);

	}

	private void saveCar(CarDAO carDAO) {
		System.out.println(" CAR...........");
		//create car object
		Car tempCar = new Car("BMW",100000,"Black");

		System.out.println("SAVING CAR..............");
		carDAO.save(tempCar);

		//Display saved car
		System.out.println("Saved CAR : "+tempCar);
	}

}
