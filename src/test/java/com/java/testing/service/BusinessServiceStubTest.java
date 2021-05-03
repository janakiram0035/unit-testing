package com.java.testing.service;

import com.java.testing.service.impl.BusinessServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceOneStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

public class BusinessServiceStubTest {

    @Test
    public void calculateSum_FromDataService() {
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        SomeDataService someDataService = new SomeDataServiceStub();
        businessService.setSomeDataService(someDataService);
        int act = businessService.calculateSumUsingDataService();
        int exp = 6;

        Assertions.assertEquals(exp, act);

    }

    @Test
    public void calculateSumUsingDataService_empty() {
        int ar[] = {};
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        SomeDataService someDataService = new SomeDataServiceEmptyStub();
        businessService.setSomeDataService(someDataService);
        int act = businessService.calculateSumUsingDataService(); //{}
        int exp = 0;

        Assertions.assertEquals(exp, act);

    }

    @Test
    public void calculateSumUsingDataService_one() {
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        SomeDataService someDataService = new SomeDataServiceOneStub();
        businessService.setSomeDataService(someDataService);
        int act = businessService.calculateSumUsingDataService();
        int exp = 5;

        Assertions.assertEquals(exp, act);

    }
}
