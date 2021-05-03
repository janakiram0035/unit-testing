package com.java.testing.test;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

    String actual ="{\"id\":1, \"name\":\"test\", \"price\":10.0}";

    @Test
    public void jsonAssertTest_avoidSpacesAndAvoidOrderAndStrictTrue() throws JSONException {

        String expectedResponse = "{\"id\":1, \"price\":10.0, \"name\":\"test\"}";

        JSONAssert.assertEquals(expectedResponse, actual, true);

    }
    @Test
    public void jsonAssertTest_avoidSpacesAndAvoidOrderAndStrictFalse() throws JSONException {

        String expectedResponse = "{\"id\":1, \"price\":10.0}";

        JSONAssert.assertEquals(expectedResponse, actual, false);

    }

    @Test
    public void jsonAssertTest_withOutEscapeChars() throws JSONException {

        //"test 2"
        String expectedResponse = "{id:1, price:10.0, name:\"test\"}";

        JSONAssert.assertEquals(expectedResponse, actual, false);

    }
}
