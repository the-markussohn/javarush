package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader fr = new BufferedReader(fileReader);

        String line = null;
        List<String> finalList = new ArrayList<>();

        while ((line = fr.readLine()) != null) {
            int count = 0;
            List<String> repeatingList = new ArrayList<>();
            for (String word :
                    words) {
                if (line.contains(word) && !repeatingList.contains(word)) {
                    count++;
                    repeatingList.add(word);
                }
            }
            if (count == 2)
                finalList.add(line);
        }

        finalList.forEach(s -> System.out.println(s));
        fileReader.close();
    }
}
