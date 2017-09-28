package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = inputReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line = fileReader.readLine();
        String[] words = line.split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0 || words == null) return new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        int pastIterationSize = 0;
        Arrays.sort(words);
        List<String> sorted = new LinkedList<>(Arrays.asList(words));
        sb.append(sorted.get(0) + " ");
        sorted.remove(0);
        while (sorted.size() > 0 && pastIterationSize != sorted.size()) {
            pastIterationSize = sorted.size();
            for (int i = 0; i < sorted.size(); i++) {
                if (sorted.get(i).toLowerCase().charAt(0) == sb.charAt(sb.length() - 2) && !sb.toString().matches(words[i])) {
                    sb.append(sorted.get(i) + " ");
                    sorted.remove(i);
                }
            }
        }
        if (sorted.size() > 0)
            sorted.forEach(s -> sb.append(s + " "));
        return new StringBuilder(sb.toString().trim());
    }
}
