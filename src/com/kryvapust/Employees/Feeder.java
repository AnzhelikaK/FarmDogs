package com.kryvapust.Employees;

import com.kryvapust.Dogs.Dog;
import com.kryvapust.Infrastructure.Food;

import java.util.Collection;

public class Feeder implements Employee {
    @Override
    public void startWork(Collection<Dog> dogs) {
        System.out.println("\t Feeding is got started.");
        for (Dog dog : dogs) {
            if (dog.isHungry()) {
                switch (dog.getTypesOfDog()) {
                    case LITTLE:
                        dog.eat(Food.FOR_LITTLE);
                        break;
                    case MIDDLE:
                        dog.eat(Food.FOR_MIDDLE);
                        break;
                    case OLD:
                        dog.eat(Food.FOR_OLD);
                }
            } else {
                System.out.println(dog + " is not hungry");
            }
        }
        System.out.println("\t Feeding is finished.");
    }

}
