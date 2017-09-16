package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader fr = new BufferedReader(fileReader);
        Map<String, Double> namesAndValues = new TreeMap<>();

        String line = null;

        while ((line = fr.readLine()) != null) {
            String[] nameAndValue = line.split(" ");
            if (namesAndValues.containsKey(nameAndValue[0]))
                namesAndValues.put(nameAndValue[0], namesAndValues.get(nameAndValue[0]) + Double.parseDouble(nameAndValue[1]));
            else
                namesAndValues.put(nameAndValue[0], Double.parseDouble(nameAndValue[1]));
        }

        namesAndValues.forEach((s, aDouble) -> System.out.println(s + " " + aDouble));
        fileReader.close();
    }
}
