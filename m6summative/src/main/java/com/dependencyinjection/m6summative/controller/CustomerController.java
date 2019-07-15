package com.dependencyinjection.m6summative.controller;

import com.dependencyinjection.m6summative.dto.Customer;
import com.dependencyinjection.m6summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {


    @Autowired
    private ServiceLayer service;

    @RequestMapping(value="/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable(name="id") int id ) {
        return service.findCustomer(id);
    }

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return service.findAllCustomers();
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer ) {
        service.updateCustomer(customer);
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable(name="id") int id ) {
        service.removeCustomer(id);
    }


}
