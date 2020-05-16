package com.kryvapust.Infrastructure;

import com.kryvapust.Dogs.Dog;
import com.kryvapust.Employees.Trainer;

import java.util.Collection;
import java.util.HashSet;

public class TrainingGround {
    private Trainer trainer;
    private Collection<Dog> dogsForTraining = new HashSet<>();

    public void startTrain(Trainer tr, Collection<Dog> dogs) {
        System.out.println("\t Dog's training is got started.");

        trainer = tr;
        dogsForTraining.addAll(dogs);
        trainer.startWork(dogsForTraining);

        System.out.println("\t Dog's training is finished.");
    }
    public Collection<Dog> getDogsAfterTraining() {
        return dogsForTraining;
    }
}
