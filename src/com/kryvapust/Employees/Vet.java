package com.kryvapust.Employees;

import com.kryvapust.Dogs.Dog;

import java.util.Collection;
import java.util.Random;

public class Vet implements Employee {
    @Override
    public void startWork(Collection<Dog> dogs) {
        System.out.println("\t Check-up is got started.");
        Random random = new Random();
        for (Dog dog : dogs) {
            if (dog.isHealthy()) {
                System.out.println(dog + " is healthy.");
            } else if (random.nextBoolean()) {
                dog.setHealthy(true);
                System.out.println(dog + " was treated.");
            } else System.out.println(dog + " isn't treated.");
        }
        System.out.println("\t Check-up is finished.");
    }
}
