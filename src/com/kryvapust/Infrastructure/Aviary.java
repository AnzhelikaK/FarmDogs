package com.kryvapust.Infrastructure;

import com.kryvapust.Dogs.Dog;
import com.kryvapust.Dogs.TypesOfDog;
import com.kryvapust.Employees.Cleaner;
import com.kryvapust.Employees.Feeder;
import com.kryvapust.Employees.Trainer;
import com.kryvapust.Employees.Vet;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Aviary {
    // Infrastructure

    private TrainingGround trainingGround;
    private Work work;

    // employees

    private Cleaner cleaner;
    private Feeder feeder;
    private Trainer trainer;
    private Vet vet;

    private Collection<Dog> dogs;
    private Collection<Dog> temporaryPlaceForDogs = new HashSet<Dog>();
    private Collection<Dog> dogsForWork = new HashSet<Dog>();
    private Collection<Dog> dogsForTraining = new HashSet<Dog>();
    private Collection<Dog> restOfDogs = new HashSet<Dog>();

    public Aviary(TrainingGround trainingGround, Work work,
                  Cleaner cleaner, Feeder feeder, Trainer trainer, Vet vet,
                  Collection<Dog> dogs) {

        this.trainingGround = trainingGround;
        this.work = work;
        this.cleaner = cleaner;
        this.feeder = feeder;
        this.trainer = trainer;
        this.vet = vet;
        this.dogs = dogs;
    }

    public void feed() {
        feeder.feed(dogs);
    }

    public void doCheckup() {
        vet.doCheckup(dogs);
    }

    public void sendToActivities() {
        prepareDogsForActivities();
        work.goToJob(dogsForWork);
        trainingGround.startTrain(trainer, dogsForTraining);
        restOfDogs.forEach(d -> d.act(" Play"));

        temporaryPlaceForDogs.addAll(work.getDogsAfterWork());
        temporaryPlaceForDogs.addAll(trainingGround.getDogsAfterTraining());
    }

    public void clean() {
        cleaner.clean(dogs);
        cleaner.clean(dogsForWork);
        cleaner.clean(dogsForTraining);

        dogs.addAll(restOfDogs);
        dogs.addAll(temporaryPlaceForDogs);

        cleaner.clean(restOfDogs);
    }

    private void prepareDogsForActivities() {
        dogsForWork = chooseDogs(dogs, d -> d.getTypesOfDog().equals(TypesOfDog.MIDDLE) || d.isHealthy());
        dogsForTraining = chooseDogs(dogs, d -> d.getTypesOfDog().equals(TypesOfDog.LITTLE));
        dogs.removeAll(dogsForWork);
        dogs.removeAll(dogsForTraining);
        restOfDogs.addAll(dogs);
    }

    private Collection<Dog> chooseDogs(Collection<Dog> dogs, Predicate<? super Dog> filter) {
        return dogs.stream().filter(filter).collect(Collectors.toSet());

    }

}
