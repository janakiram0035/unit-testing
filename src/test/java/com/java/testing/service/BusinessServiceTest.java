package com.java.testing.service;

import com.java.testing.service.BusinessService;
import com.java.testing.service.impl.BusinessServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BusinessServiceTest {


    @Test
    public void calculateSum_basic() {
        int ar[] = {1,2 ,3};
        BusinessService businessService = new BusinessServiceImpl();
        int act = businessService.calculateSum(ar);
        int exp = 6;

        Assertions.assertEquals(exp, act);

    }

    @Test
    public void calculateSum_empty() {
        int ar[] = {};
        BusinessService businessService = new BusinessServiceImpl();
        int act = businessService.calculateSum(ar);
        int exp = 0;

        Assertions.assertEquals(exp, act);

    }

    @Test
    public void calculateSum_one() {
        int ar[] = {1};
        BusinessService businessService = new BusinessServiceImpl();
        int act = businessService.calculateSum(ar);
        int exp = 1;

        Assertions.assertEquals(exp, act);

    }




}
