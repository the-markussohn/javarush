package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        Map<Character, Integer> symbolsAndFrequency = new TreeMap<>();

        while (fileReader.ready()){
            char character = (char) fileReader.read();
            if (symbolsAndFrequency.containsKey(character)) {
                int count = symbolsAndFrequency.get(character);
                symbolsAndFrequency.put(character, count + 1);
            } else {
                symbolsAndFrequency.put(character, 1);
            }
        }

        symbolsAndFrequency.forEach((k, v) -> System.out.println(k + " " + v));
        fileReader.close();
    }
}
