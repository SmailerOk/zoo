package com.level.zoo.animal;

import com.level.zoo.animal.impl.Cat;
import com.level.zoo.animal.impl.Dog;
import com.level.zoo.animal.impl.Elephant;
import com.level.zoo.animal.impl.Tiger;

/**
 * Created by cube on 09.11.2017.
 */
public abstract class AbstractAnimal implements Animal {
    public String goToToilet() {
        return "=^-^= срунь срунь";
    }

    @Override
    public String toString() {
        return getAnimalClass() + "{" +
                "в туалете :" + goToToilet() +
                "}";
    }

    public int age;
    public String name;
}
