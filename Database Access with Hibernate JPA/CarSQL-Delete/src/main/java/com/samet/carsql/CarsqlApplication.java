package com.samet.carsql;

import com.samet.carsql.dao.CarDAO;
import com.samet.carsql.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsqlApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(CarDAO carDAO){
		return  runner ->{

			deleteCar(carDAO);
		};

	}

	private void deleteCar(CarDAO carDAO) {
		try {
			System.out.println("Please write down here the ID of car you want to delete");
			Scanner input = new Scanner(System.in);
			int carId = input.nextInt();
			carDAO.delete(carId);
			System.out.println("DELETED");
		}catch (Exception e){
			System.out.println("Please input a valid ID");
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
