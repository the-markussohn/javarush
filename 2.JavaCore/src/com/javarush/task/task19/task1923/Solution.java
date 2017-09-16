package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fOneReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fOneReader);
        FileWriter fTwoWriter = new FileWriter(args[1]);

        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].matches(".*\\d.*"))
                    fTwoWriter.write(words[i] + " ");
            }
        }

        fOneReader.close();
        fTwoWriter.close();
    }
}
