package com.level.zoo.animal.impl;

import com.level.zoo.animal.AbstractAnimal;

/**
 * Created by cube on 09.11.2017.
 */
public class Cat extends AbstractAnimal {
    @Override
    public void say() {
        System.out.println("Мяу");
    }

    @Override
    public String getAnimalClass() {
        return "Кошак";
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

    @Override
    public int getMaxAge() {
        return 23;
    }

    public int maxAge = 20;
}
