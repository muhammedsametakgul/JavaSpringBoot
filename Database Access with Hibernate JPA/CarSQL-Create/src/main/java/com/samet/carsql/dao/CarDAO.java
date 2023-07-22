package com.samet.carsql.dao;

import com.samet.carsql.entity.Car;
import org.springframework.stereotype.Repository;


public interface CarDAO {

    void save(Car car);
}
