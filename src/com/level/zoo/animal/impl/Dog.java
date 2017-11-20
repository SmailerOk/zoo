package com.level.zoo.animal.impl;

import com.level.zoo.animal.AbstractAnimal;

/**
 * Created by cube on 09.11.2017.
 */
public class Dog extends AbstractAnimal {
    @Override
    public void say() {
        System.out.println("Гав");
    }

    @Override
    public String getAnimalClass() {
        return "Собакен";
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void setAge(int age) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}
