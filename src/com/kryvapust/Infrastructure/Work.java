package com.kryvapust.Infrastructure;

import com.kryvapust.Dogs.Dog;

import java.util.Collection;
import java.util.HashSet;

public class Work {
    private Collection<Dog> workDogs = new HashSet<>();

    public void goToJob(Collection<Dog> dogs) {
        System.out.println("\t Dog's work is got started.");

        workDogs.addAll(dogs);
        for (Dog dog : workDogs) {
            if (dog.getAge() < 6) {
                dog.act(" work in police");
            } else dog.act(" work in MES");
        }
        System.out.println("\t Dog's work is finished.");
    }

    public Collection<Dog> getDogsAfterWork() {
        return workDogs;
    }
}
