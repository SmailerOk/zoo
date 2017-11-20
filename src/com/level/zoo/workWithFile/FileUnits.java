package com.level.zoo.workWithFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.awt.SystemColor.text;

public class FileUnits {

    public static void main(String[] args) throws IOException {
        String fileName = "src/com/level/zoo/workWithFile/zooFile";
        String text = "Text text";
        FileWorker.write(fileName, text);
        System.out.println(FileWorker.read(fileName));
    }
}
