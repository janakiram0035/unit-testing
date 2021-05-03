package com.java.testing.service.impl;

import com.java.testing.service.BusinessService;
import com.java.testing.service.SomeDataService;

import java.util.Arrays;

public class BusinessServiceImpl implements BusinessService {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] ar) {
        return Arrays.stream(ar).boxed().reduce((n, t) -> t+=n).orElse(0);
    }

    public int calculateSumUsingDataService() {
        int ar[] = someDataService.retrieveAllData();
        return Arrays.stream(ar).boxed().reduce((n, t) -> t+=n).orElse(0);
    }
}
