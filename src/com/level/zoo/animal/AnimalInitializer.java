package com.level.zoo.animal;

import com.level.zoo.animal.impl.Cat;
import com.level.zoo.animal.impl.Dog;
import com.level.zoo.animal.impl.Elephant;
import com.level.zoo.animal.impl.Tiger;

/**
 * Created by cube on 09.11.2017.
 */
public class AnimalInitializer {

    private static String[] animalsName = new String[4];
    private static Animal[] animalInstances = {
            new Tiger(), new Elephant(), new Cat(), new Dog()
    };
    private static int counter = 0;

    static {
        registrationAnimal();
    }

    private static void registrationAnimal() {
        for (Animal animal : animalInstances) {
            if (counter == animalsName.length) changeAnimalNameArraySize();
            animalsName[counter++] = animal.getAnimalClass();
        }
    }

    // TODO: 09.11.2017 some magic for you, dudes =)
    private static void changeAnimalNameArraySize() {
        String[] newAnimalNameArray = new String[animalsName.length + animalsName.length / 2 + 1];
        System.arraycopy(animalsName, 0, newAnimalNameArray, 0, animalsName.length);
        animalsName = newAnimalNameArray;
    }

    public static int getAnimalArraySize() {
        return counter;
    }

    public static String[] getAnimalsName() {
        return animalsName;
    }

    public static Animal getAnimalFromMenu(int i) throws IllegalAccessException, InstantiationException {
        return animalInstances[i-1].getClass().newInstance();
    }

    public static Animal createAnimalByName(String animalType, String animalName, int animalAge) throws IllegalAccessException, InstantiationException {
        AbstractAnimal animal;
        switch (animalType){
            case "Tiger":
                animal = new Tiger();
                animal.name = animalName;
                animal.age = animalAge;
                break;
            case "Elephant":
                animal = new Elephant();
                animal.name = animalName;
                animal.age = animalAge;
                break;
            case "Cat":
                animal = new Cat();
                animal.name = animalName;
                animal.age = animalAge;
                break;
            case "Dog":
                animal = new Dog();
                animal.name = animalName;
                animal.age = animalAge;
                break;
            default: throw new IllegalArgumentException("Invalid animal: " + animalType);
        }
        return animal;
    }
}
