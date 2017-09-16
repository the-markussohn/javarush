package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Solution {
    public static void main(String[] args) {
        String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int numOfEngLetters = 0;
        try {
            FileReader fileReader = new FileReader(args[0]);
            while (fileReader.ready()) {
                int letter = fileReader.read();
                if (englishAlphabet.indexOf(Character.toLowerCase((char)letter)) != -1)
                    numOfEngLetters++;
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(numOfEngLetters);
    }
}
