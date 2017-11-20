package com.level.zoo;

import com.level.zoo.animal.AbstractAnimal;
import com.level.zoo.animal.Animal;
import com.level.zoo.animal.AnimalInitializer;
import com.level.zoo.workWithFile.FileWorker;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by cube on 09.11.2017.
 */
public class MenuStandardComponent {
    public static final String[] ZOO_TYPE_MENU = {
        "Как вы хотите создать зоопарк?",
            "1. Вручную",
            "2. Создать случайными животными",
            "3. Создать зоопарк из файла"
    };

    public final static String[] CHANGE_ZOO_LENGTH = {
            "Желаете ли увеличить зоопарк?",
            "1. Да",
            "2. Нет"
    };

    public final static String[] ADD_NEW_ANIMAL = new String[AnimalInitializer.getAnimalArraySize() + 1];

    static {
        ADD_NEW_ANIMAL[0] = "Добавте животное";
        for (int i = 1; i < ADD_NEW_ANIMAL.length; i++) {
            ADD_NEW_ANIMAL[i] = i + ". " + AnimalInitializer.getAnimalsName()[i - 1];
        }
    }


    public static void menuWriter(String[] menu) {
        for (String item : menu) {
            System.out.println(item);
        }
    }

    public static void selectZooType() throws InstantiationException, IllegalAccessException, IOException {
        Scanner scanner = new Scanner(System.in);
        MenuStandardComponent.menuWriter(MenuStandardComponent.ZOO_TYPE_MENU);
        switch ((scanner.nextInt())){
            case 1:
                createZooManually();
                break;
            case 2:
                createZooRandom();
                break;
            case 3:
                createZooFromFile();
                break;
        }
    }

    public static void createZooManually() throws InstantiationException, IllegalAccessException {
        boolean exitFromCreator = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя зоопарка");
        Zoo zoo = new Zoo(scanner.nextLine());
        scanner.nextLine();
        MenuStandardComponent.menuWriter(MenuStandardComponent.ADD_NEW_ANIMAL);
        while (!exitFromCreator) {
            exitFromCreator = !zoo.addAnimal(AnimalInitializer.getAnimalFromMenu(scanner.nextInt()));
        }

        System.out.println(zoo);
    }


    public static void createZooFromFile() throws IOException, InstantiationException, IllegalAccessException {
        String fileName = "src/com/level/zoo/workWithFile/zooFile";
        String s = FileWorker.newRead(fileName);
        Zoo zoo = new Zoo(s.split(" ")[0]);
        for (int i = 1; i <= s.split( " ").length - 1 ;){
            zoo.addAnimal(AnimalInitializer.createAnimalByName(s.split(" ")[i],s.split(" ")[i+1],Integer.parseInt(s.split(" ")[i+2])));
            i = i + 3;
        }
        System.out.println(zoo.toString());
    }

    public static void createZooRandom() throws InstantiationException, IllegalAccessException {
        System.out.println("Сколько животных хотите создать?");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int zooLength = scanner.nextInt();
        Zoo zoo = new Zoo("Random zoo");
        for (int i = 0; i < zooLength; i++){
            zoo.addAnimal(AnimalInitializer.getAnimalFromMenu(random.nextInt(4)+1));
        }
        System.out.println(zoo);
    }
}
