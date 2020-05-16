package com.kryvapust;

import com.kryvapust.Dogs.Dog;
import com.kryvapust.Employees.Cleaner;
import com.kryvapust.Employees.Feeder;
import com.kryvapust.Employees.Trainer;
import com.kryvapust.Employees.Vet;
import com.kryvapust.Infrastructure.Aviaries;
import com.kryvapust.Infrastructure.FarmDogs;
import com.kryvapust.Infrastructure.TrainingGround;
import com.kryvapust.Infrastructure.Work;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        final int AMOUNT_DOGS=10;
        Collection<Dog> dogs = createDogs(AMOUNT_DOGS);

        TrainingGround trainingGround = new TrainingGround();
        Work work = new Work();
        Aviaries aviaries = new Aviaries();
        Cleaner cleaner = new Cleaner();
        Feeder feeder = new Feeder();
        Trainer trainer = new Trainer();
        Vet vet = new Vet();

        FarmDogs farmDogs = new FarmDogs(aviaries,trainingGround, work,
                cleaner, feeder, trainer, vet);

        farmDogs.acceptDogs(dogs);

        System.out.println(" Dog's state in the beginning of day.");
        dogs.forEach(Dog::state);

        farmDogs.feed();
        farmDogs.doCheckup();
        farmDogs.sendToActivities();
        farmDogs.clean();
        farmDogs.feed();

        System.out.println(" Dog's state in the end of day.");
        dogs.forEach(Dog::state);
    }

    private static Collection<Dog> createDogs(int amount) {
        return Stream.generate(Dog::new).limit(amount).collect(Collectors.toSet());
    }
}
