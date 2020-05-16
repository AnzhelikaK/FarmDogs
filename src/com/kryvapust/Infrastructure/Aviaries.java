package com.kryvapust.Infrastructure;

import com.kryvapust.Dogs.Dog;
import com.kryvapust.Dogs.TypesOfDog;
import com.kryvapust.Employees.Employee;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Aviaries {

    private Collection<Dog> allDogs;
    private Collection<Dog> temporaryPlaceForDogs = new HashSet<Dog>();
    private Collection<Dog> dogsForWork = new HashSet<Dog>();
    private Collection<Dog> dogsForTraining = new HashSet<Dog>();
    private Collection<Dog> restOfDogs = new HashSet<Dog>();

    Collection<Dog> getAllDogs() {
        return allDogs;
    }

    void setAllDogs(Collection<Dog> allDogs) {
        this.allDogs = allDogs;
    }

    Collection<Dog> getTemporaryPlaceForDogs() {
        return temporaryPlaceForDogs;
    }

    Collection<Dog> getDogsForWork() {
        return dogsForWork;
    }

    Collection<Dog> getDogsForTraining() {
        return dogsForTraining;
    }

    Collection<Dog> getRestOfDogs() {
        return restOfDogs;
    }


    void letInEmployee(Employee employee) {
        employee.startWork(allDogs);
    }

    void meetDogs(Collection<Dog> dogs) {
        temporaryPlaceForDogs.addAll(dogs);
    }

    void prepareDogsForActivities() {
        dogsForWork = chooseDogs(d -> d.getTypesOfDog().equals(TypesOfDog.MIDDLE) || d.isHealthy());
        allDogs.removeAll(dogsForWork);
        dogsForTraining = chooseDogs(d -> d.getTypesOfDog().equals(TypesOfDog.LITTLE));
        allDogs.removeAll(dogsForTraining);
        restOfDogs.addAll(allDogs);
    }

    private Collection<Dog> chooseDogs(Predicate<? super Dog> filter) {
        return allDogs.stream().filter(filter).collect(Collectors.toSet());
    }

    void placeDogs() {
        allDogs.addAll(temporaryPlaceForDogs);
    }
}
