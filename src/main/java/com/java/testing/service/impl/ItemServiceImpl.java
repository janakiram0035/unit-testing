package com.java.testing.service.impl;

import com.java.testing.model.Item;
import com.java.testing.repository.ItemRepository;
import com.java.testing.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Item getHardcodedValues() {

        System.out.println("came to item service");
        return new Item(2L, "Item 2", 20.00, 2L);
    }

    @Override
    public List<Item> retrieveAllItems() {
        return itemRepository.findAll().stream().peek((item) -> item.setValue(item.getPrice().longValue()*item.getQuantity())
        ).collect(Collectors.toList());
    }
}
