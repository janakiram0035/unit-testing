package com.java.testing.controller;

import com.java.testing.controller.ItemController;
import com.java.testing.model.Item;
import com.java.testing.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void getItem_basic() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1, \"name\":\"test\"}"))
                .andReturn();


    }


    //A mock by default creates item as null from item service instead of actual return
    //so here we have return unit test till controller unit, even service is not working then this test case passes.
    // so it is for controller unit. Here we are mocking out business layer.
    @Test
    public void getItem_fromService() throws Exception {

        Mockito.when(itemService.getHardcodedValues()).thenReturn(new Item(2L, "test 2", 20.0, 2L));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/dummy-item-from-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{id:2, name:\"test 2\"}"))
                .andReturn();


    }

    @Test
    public void retrieveAllItemsFromDb_basic() throws Exception {


        Mockito.when(itemService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(2L, "Item1", 20.00, 20L),
                        new Item(3L, "Item2", 30.00, 30L))
        );
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/items-from-db")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{id:2,name:Item1, price:20.00, quantity:20},{id:3,name:Item2,price:30.00, quantity:30}]"))
                .andReturn();

    }
}
