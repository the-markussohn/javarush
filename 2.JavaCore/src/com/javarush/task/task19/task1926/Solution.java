package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String file = fileNameReader.readLine();
        fileNameReader.close();

        FileReader fr = new FileReader(file);
        BufferedReader fileReader = new BufferedReader(fr);

        String line = null;

        while ((line = fileReader.readLine()) != null) {
            System.out.println(new StringBuilder(line).reverse().toString());
        }

        fr.close();
    }
}
