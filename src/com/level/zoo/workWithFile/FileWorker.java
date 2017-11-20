package com.level.zoo.workWithFile;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWorker {

    public static void write(String fileName, String text){

        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String read(String fileName) throws FileNotFoundException{
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try{
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null){
                    stringBuilder.append(s);
                    stringBuilder.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static String newRead (String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        return stringBuilder.toString();
    }
}
