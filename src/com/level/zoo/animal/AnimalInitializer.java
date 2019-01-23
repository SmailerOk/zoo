package com.level.zoo.animal;

import com.level.zoo.animal.impl.Cat;
import com.level.zoo.animal.impl.Dog;
import com.level.zoo.animal.impl.Elephant;
import com.level.zoo.animal.impl.Tiger;
import com.level.zoo.workWithFile.FileWorker;

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
        String fileName = "src/com/level/zoo/workWithFile/zooFile2";
        switch (animalType){
            case "Tiger":
                animal = new Tiger();
                animal.name = animalName;
                if (animal.inMaxAgeInterval(animal.getMaxAge(), animalAge)){
                    animal.age = animalAge;
                } else {
                    System.out.println("Твоя скотина слишком стара (или молода) чтобы жить.");
                    animal.age = animal.getMaxAge();
                }
                break;
            case "Elephant":
                animal = new Elephant();
                animal.name = animalName;
                if (animal.inMaxAgeInterval(animal.getMaxAge(), animalAge)){
                    animal.age = animalAge;
                } else {
                    System.out.println("Твое животное слишком стара (или молода) чтобы жить.");
                    animal.age = animal.getMaxAge();
                }
                break;
            case "Cat":
                animal = new Cat();
                animal.name = animalName;
                if (animal.inMaxAgeInterval(animal.getMaxAge(), animalAge)){
                    System.out.println(animal.inMaxAgeInterval(animal.getMaxAge(), animalAge));
                    animal.age = animalAge;
                } else {
                    System.out.println("Твоя скотина слишком стара (или молода) чтобы жить.");
                    animal.age = animal.getMaxAge();
                }
                break;
            case "Dog":
                animal = new Dog();
                animal.name = animalName;
                if (animal.inMaxAgeInterval(animal.getMaxAge(), animalAge)){
                    animal.age = animalAge;
                } else {
                    System.out.println("Твоя скотина слишком стара (или молода) чтобы жить.");
                    animal.age = animal.getMaxAge();
                }
                break;
            default: throw new IllegalArgumentException("Invalid animal: " + animalType);
        }
        System.out.println(animal.toString());
        System.out.println(animal.name);
        System.out.println(animal.age);
        return animal;
    }
}
