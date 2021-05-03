package com.java.testing.controller;

import com.java.testing.model.Item;
import com.java.testing.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/dummy-item")
    public ResponseEntity<Item> getItem() {
        Item item = new Item(1L, "test", 22.00, 1L);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/dummy-item-from-service")
    public ResponseEntity<Item> getItemFromService() {

        Item item = itemService.getHardcodedValues();

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/items-from-db")
    public ResponseEntity<List<Item>> getItemsFromDb() {

        List<Item> items = itemService.retrieveAllItems();

        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
