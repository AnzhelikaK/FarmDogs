package com.kryvapust.Employees;

import com.kryvapust.Dogs.Dog;

import java.util.Collection;


public class Trainer {
    public void train(Collection<Dog> dogs) {
        dogs.forEach(d -> d.act(" Training"));
    }
}
