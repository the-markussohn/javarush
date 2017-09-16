package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader fr = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(args[1]);

        String line = null;
        String longWords = "";

        while ((line = fr.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6)
                    longWords += words[i] + ",";
            }
        }
        fileWriter.write(longWords.substring(0, longWords.length() - 1));
        fileReader.close();
        fileWriter.close();
    }
}
