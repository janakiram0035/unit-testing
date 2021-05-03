package com.java.testing.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Person {

    public String name;
    public String department;

    public Person(String name, String department) {
        super();
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", dept=" + department + "]";
    }

    public static void main(String[] args) {
        List<Person> pList = new ArrayList<>() {{
            add(new Person("HR1", "HR"));
            add(new Person("Admin1", "Admin"));
            add(new Person("Payroll1", "Payroll"));
            add(new Person("Hr2", "HR"));
            add(new Person("Admin2", "Admin"));
            add(new Person("ECE", "ECE"));
            add(new Person("Pay2", "Payroll"));
        }};

        Map<String, List<Person>> map = pList.stream().map((person) -> {
            if(person.department.equals( "HR")) {
                person.department = "Human Resources";
            }
            return person;
        }).collect(Collectors.groupingBy((per) -> per.department));

    }
}
