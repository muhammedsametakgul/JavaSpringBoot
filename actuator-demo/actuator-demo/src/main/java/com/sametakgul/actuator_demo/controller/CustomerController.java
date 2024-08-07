package com.sametakgul.actuator_demo.controller;

import com.sametakgul.actuator_demo.model.Customer;
import com.sametakgul.actuator_demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return  customerService.getCustomerById(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

}
