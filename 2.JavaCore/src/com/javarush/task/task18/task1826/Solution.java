package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream(args[1]);
        FileOutputStream fileWriter = new FileOutputStream(args[2]);

        switch (args[0]) {
            case "-e":
                while (fileReader.available() > 0) {
                    fileWriter.write(fileReader.read() + 1);
                }
                break;
            case "-d":
                while (fileReader.available() > 0) {
                    fileWriter.write(fileReader.read() - 1);
                }
                break;
            default:
                break;
        }

        fileReader.close();
        fileWriter.close();
    }

}
