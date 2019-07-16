package com.dependencyinjection.m6summative.dao;

import com.dependencyinjection.m6summative.dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemDaoTest {

    @Autowired
    protected InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
//        List<Coffee> cList = CoffeeDao.getAllCoffees();
//
//        cList.stream()
//                .forEach(coffee -> CoffeeDao.deleteCoffee(coffee.getCoffee_id()));
//
//        List<Roaster> rList = RoasterDao.getAllRoasters();
//
//        rList.stream()
//                .forEach(roaster -> RoasterDao.deleteRoaster(roaster.getRoaster_id()));
    }


    @Test
    public void addGetDeleteInvoiceItem() {
        Invoice invoice = new Invoice();
        invoice.setOrderDate();

    }

}
