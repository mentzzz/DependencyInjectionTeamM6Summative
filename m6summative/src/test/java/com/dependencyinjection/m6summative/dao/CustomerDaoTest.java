package com.dependencyinjection.m6summative.dao;

import com.dependencyinjection.m6summative.dto.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {



    @Autowired
    protected CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Customer> cList = customerDao.getAllCustomers();

        cList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));
    }


    @Test
    public void addGetDeleteCustomer() {

        // delete all Customers from db
        List<Customer> cList = customerDao.getAllCustomers();

        cList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));

        List<Customer> listFromDatabase = customerDao.getAllCustomers();
        // check to see if the length of the list is 0
        Assert.assertEquals(0, listFromDatabase.size());


        // define customer object
        Customer customer = new Customer();
        customer.setFirstName("brian");
        customer.setLastName("smith");
        customer.setEmail("brian@mail");
        customer.setCompany("ezShop");
        customer.setPhone("7048887777");
        // add customer to db
        customer = customerDao.addCustomer(customer);

        // create a new customer object using the previous customerId
        Customer fromDatabase = new Customer();
        fromDatabase = customerDao.getCustomer(customer.getCustomerId());

        // compare the two customer objects
        Assert.assertEquals(customer, fromDatabase);




    }


}
