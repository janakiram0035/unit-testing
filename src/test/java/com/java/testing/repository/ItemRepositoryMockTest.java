package com.java.testing.repository;

import com.java.testing.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ItemRepositoryMockTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void findAll() {

        List<Item> itemList = itemRepository.findAll();

        Assertions.assertEquals(3, itemList.size());

    }
}
