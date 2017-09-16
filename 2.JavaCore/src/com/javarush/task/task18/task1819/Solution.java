package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readFileNames = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = readFileNames.readLine();
        String fileTwo = readFileNames.readLine();
        readFileNames.close();

        FileInputStream readFirstFile = new FileInputStream(fileOne);
        String firstFileContent = "";

        while (readFirstFile.available() > 0) {
            firstFileContent += (char) readFirstFile.read();
        }

        readFirstFile.close();

        FileOutputStream writeFirstFile = new FileOutputStream(fileOne);
        FileInputStream readSecondFile = new FileInputStream(fileTwo);
        String secondFileContent = "";

        while (readSecondFile.available() > 0) {
            secondFileContent += (char) readSecondFile.read();
        }

        writeFirstFile.write((secondFileContent + firstFileContent).getBytes());

        readSecondFile.close();
        writeFirstFile.close();
    }
}
