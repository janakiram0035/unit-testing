package com.java.testing.service;

import com.java.testing.model.Item;

import java.util.List;

public interface ItemService {

    Item getHardcodedValues();

    List<Item> retrieveAllItems();
}
