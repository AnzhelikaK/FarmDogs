package com.kryvapust.Employees;

import com.kryvapust.Dogs.Dog;

import java.util.Collection;

public class Cleaner {

    public Collection<Dog> clean(Collection<Dog> dogs) {
        dogs.clear();
        System.out.println("I cleaned all places where dogs are living.");
        return dogs;
    }
}

