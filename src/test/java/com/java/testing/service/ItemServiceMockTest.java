package com.java.testing.service;

import com.java.testing.model.Item;
import com.java.testing.repository.ItemRepository;
import com.java.testing.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceMockTest {

    @Mock
    private ItemRepository itemRepository;

    @MockBean
    private ItemServiceImpl itemService;

    @Test
    public void retrieveAllItems_basic() {
        List<Item> items = Arrays.asList(
                new Item(2L, "Item1", 20.00, 20L),
                new Item(3L, "Item2", 30.00, 30L)
        );
        Mockito.when(itemRepository.findAll()).thenReturn(
               items
        );

        List<Item> items1 = itemService.retrieveAllItems();

        Assertions.assertEquals(400L, items1.get(0).getValue());
        Assertions.assertEquals(900L, items1.get(1).getValue());


    }
}
