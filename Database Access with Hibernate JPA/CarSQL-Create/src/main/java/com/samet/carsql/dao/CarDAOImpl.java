package com.samet.carsql.dao;

import com.samet.carsql.entity.Car;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void save(Car car) {
    entityManager.persist(car);
    }
}
