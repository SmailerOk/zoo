package com.level.zoo.animal.impl;

import com.level.zoo.animal.AbstractAnimal;

/**
 * Created by cube on 09.11.2017.
 */
public class Elephant extends AbstractAnimal {
    @Override
    public void say() {
        System.out.println("Ту-тууу!");
    }

    @Override
    public String getAnimalClass() {
        return "Слон";
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
    public String goToToilet() {
       return "Лучше не знать....";
    }
}
