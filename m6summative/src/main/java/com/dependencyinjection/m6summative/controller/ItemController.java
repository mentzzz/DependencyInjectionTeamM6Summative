package com.dependencyinjection.m6summative.controller;

import com.dependencyinjection.m6summative.dto.Item;
import com.dependencyinjection.m6summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ServiceLayer service;

    @RequestMapping(value="/item", method = RequestMethod.POST)
    public Item createItem(@RequestBody Item item) {
        return service.saveItem(item);
    }

    @RequestMapping(value="/item/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable(name="id") int id ) {
        return service.findItem(id);
    }

    @RequestMapping(value="/items", method = RequestMethod.GET)
    public List<Item> getAllItems() {
        return service.findAllItems();
    }

    @RequestMapping(value="/item/{id}", method = RequestMethod.PUT)
    public void updateItem(@RequestBody Item item ) {
        service.updateItem(item);
    }

    @RequestMapping(value="/item/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable(name="id") int id ) {
        service.removeItem(id);
    }


}
