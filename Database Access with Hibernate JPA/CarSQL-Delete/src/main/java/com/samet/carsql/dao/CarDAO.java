package com.samet.carsql.dao;

import com.samet.carsql.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CarDAO {

    Car findById(Integer id);

    void delete(Integer id);

}
