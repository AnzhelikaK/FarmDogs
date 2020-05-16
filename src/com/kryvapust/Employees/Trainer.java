package com.kryvapust.Employees;

import com.kryvapust.Dogs.Dog;

import java.util.Collection;


public class Trainer implements Employee{
    @Override
    public void startWork(Collection<Dog> dogs) {
        dogs.forEach(d -> d.act(" Training"));
    }
}
