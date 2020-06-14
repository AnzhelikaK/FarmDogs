package com.kryvapust.Dogs;

import com.kryvapust.Infrastructure.Food;

import java.util.Random;

public class Dog {

    private final String name;
    private int age;
    private boolean hungry = true;
    private boolean healthy;
    private static int count = 0;
    private static final Random RANDOM = new Random();

    public Dog() {
        this(RANDOM.nextInt(16));
    }

    public Dog(int age) {
        ++count;
        name = "dog" + count + (char) (65 + RANDOM.nextInt(26));
        setHealthy(RANDOM.nextBoolean());
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public TypesOfDog getTypesOfDog() {
        if (age < 4) {
            return TypesOfDog.LITTLE;
        } else if (age < 9) {
            return TypesOfDog.MIDDLE;
        } else {
            return TypesOfDog.OLD;
        }
    }

    public boolean isHungry() {
        return hungry;
    }

    private void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isTrained() {
        return age > 3;
    }

    public void eat(Food food) {
        System.out.println(toString() + " is eating - " + food);
        hungry = true;
    }

    public void act(String activity) {
        System.out.println(toString() + "went to " + activity);
        setHungry(RANDOM.nextBoolean());
    }

    public void state() {
        System.out.println(toString()
                + " Age: " + age
                + " Hungry: " + hungry
                + " Health: " + healthy
                + " Trained: " + isTrained());
    }

    @Override
    public String toString() {
        return name + "( " + getTypesOfDog() + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return getName().equals(dog.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
