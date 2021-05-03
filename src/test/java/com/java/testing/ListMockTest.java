package com.java.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ListMockTest {

    List<String> mock = Mockito.mock(List.class);

    @Test
    public void mockWithList() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(5);

        Assertions.assertEquals(5, 5);
    }

    @Test
    public void mockListWithDifferentValues() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(5).thenReturn(10);

        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals(10, list.size());
    }

    @Test
    public void mockListWithParameters() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("Janakiram");

        Assertions.assertEquals("Janakiram", list.get(0));
    }

    @Test
    public void returnWithGenericParams() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("Janakiram");

        Assertions.assertEquals("Janakiram", list.get(0));
        Assertions.assertEquals("Janakiram", list.get(2));
    }

    //This to verify specific method called or not.
    @Test
    public void verifyMethodCalls() {
        String value = mock.get(0);
        String value2 = mock.get(1);

        Mockito.verify(mock).get(0);
        Mockito.verify(mock, Mockito.times(2)).get(Mockito.anyInt());
        Mockito.verify(mock, Mockito.atLeastOnce()).get(Mockito.anyInt());
        Mockito.verify(mock, Mockito.atMost(2)).get(Mockito.anyInt());
        Mockito.verify(mock, Mockito.never()).get(2);

    }


    @Test
    public void argumentCapturing() {
        mock.add("SomeString");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mock).add(argumentCaptor.capture());

        Assertions.assertEquals("SomeString", argumentCaptor.getValue());
    }

    @Test
    public void multipleCallsArgumentCapturing() {
        mock.add("SomeString1");
        mock.add("SomeString2");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(mock, Mockito.times(2)).add(argumentCaptor.capture());
        var i =0;
        var j = "hello";
      /*  if(i == j) {

        }*/
        var allValues = argumentCaptor.getAllValues();
        Assertions.assertEquals("SomeString1", allValues.get(0));
        Assertions.assertEquals("SomeString2", allValues.get(1));

    }

    @Test
    public void mocking() {

        ArrayList arrayListMock =  Mockito.mock(ArrayList.class);

        System.out.println(arrayListMock.get(0)); // null

        arrayListMock.size(); //0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.get(10000));
        arrayListMock.size();
        Mockito.when(arrayListMock.size()).thenReturn(10);
        System.out.println(arrayListMock.size());
    }

    @Test
    public void spying() {

        ArrayList arrayListSpy =  Mockito.spy(ArrayList.class);

        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // null

        arrayListSpy.size(); //0
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.get(1));
        arrayListSpy.size();
        Mockito.when(arrayListSpy.size()).thenReturn(10);
        System.out.println(arrayListSpy.size());

        Mockito.when(arrayListSpy.size()).thenReturn(10);
        System.out.println(arrayListSpy.size());

    }
}
