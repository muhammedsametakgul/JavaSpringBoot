package com.samet.carsql.dao;

import com.samet.carsql.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //supports component scanning
public class CarDAOImpl implements CarDAO{


    //define entity manager
    private  EntityManager entityManager ;

    //constructor

    @Autowired
    public CarDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Car findById(Integer id) {
        return entityManager.find(Car.class,id);
    }



    @Override
    @Transactional
    public void delete(Integer id) {
        Car myCar=entityManager.find(Car.class,id);

        //delete selected car
        entityManager.remove(myCar);
    }
}
