package com.kryvapust.Employees;

import com.kryvapust.Dogs.Dog;

import java.util.Collection;

public class Cleaner implements Employee {
    @Override
    public void startWork(Collection<Dog> dogs) {
        dogs.clear();
        System.out.println("I cleaned one of the places where dogs are living.");
    }
}

