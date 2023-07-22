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
    public List<Car> findAll() {
        TypedQuery<Car> theQuery=entityManager.createQuery("FROM Car",Car.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Car> findByName(String name) {
        TypedQuery<Car> theQuery=entityManager.createQuery("FROM Car WHERE name=:theData",Car.class);

        //Set parameters
        theQuery.setParameter("theData",name);


        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Car car) {
        entityManager.merge(car);
    }
}
