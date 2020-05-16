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


public class FarmDogs {
    // Infrastructure
    Aviaries aviaries;
    private TrainingGround trainingGround;
    private Work work;

    // employees

    private Cleaner cleaner;
    private Feeder feeder;
    private Trainer trainer;
    private Vet vet;

    public FarmDogs(Aviaries aviaries, TrainingGround trainingGround, Work work,
                    Cleaner cleaner, Feeder feeder, Trainer trainer, Vet vet) {

        this.aviaries = aviaries;
        this.trainingGround = trainingGround;
        this.work = work;
        this.cleaner = cleaner;
        this.feeder = feeder;
        this.trainer = trainer;
        this.vet = vet;
    }

    public void acceptDogs(Collection<Dog> dogs) {
        aviaries.setAllDogs(dogs);
    }

    public void feed() {
        aviaries.letInEmployee(feeder);
    }

    public void doCheckup() {
        aviaries.letInEmployee(vet);
    }

    public void sendToActivities() {
        aviaries.prepareDogsForActivities();
        work.goToJob(aviaries.getDogsForWork());
        trainingGround.startTrain(trainer, aviaries.getDogsForTraining());
        aviaries.getRestOfDogs().forEach(d -> d.act(" Play"));

        aviaries.meetDogs(work.getDogsAfterWork());
        aviaries.meetDogs(trainingGround.getDogsAfterTraining());
        aviaries.meetDogs(aviaries.getRestOfDogs());
    }
    public void clean() {
        cleaner.startWork(aviaries.getAllDogs());
        cleaner.startWork(aviaries.getDogsForWork());
        cleaner.startWork(aviaries.getDogsForWork());
        aviaries.placeDogs();
        cleaner.startWork(aviaries.getTemporaryPlaceForDogs());
    }
}
