package com.java.testing.service;

import com.java.testing.service.BusinessService;
import com.java.testing.service.SomeDataService;
import com.java.testing.service.impl.BusinessServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BusinessServiceMockTest {



    @Mock
    SomeDataService someDataServiceMock;

    @InjectMocks
    BusinessServiceImpl businessService;

    @BeforeEach
    public void beforeEach() {
        businessService.setSomeDataService(someDataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic() {

        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        int act = businessService.calculateSumUsingDataService();
        int exp = 6;

        Assertions.assertEquals(exp, act);

    }

    @Test
    public void calculateSumUsingDataService_empty() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        int act = businessService.calculateSumUsingDataService();
        int exp = 0;

        Assertions.assertEquals(exp, act);

    }

    @Test
    public void calculateSumUsingDataService_one() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        int act = businessService.calculateSumUsingDataService();
        int exp = 5;

        Assertions.assertEquals(exp, act);

    }
}
