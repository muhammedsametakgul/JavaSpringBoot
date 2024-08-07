package com.sametakgul.actuator_demo.repository;

import com.sametakgul.actuator_demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
