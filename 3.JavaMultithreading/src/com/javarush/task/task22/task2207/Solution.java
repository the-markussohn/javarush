package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        String file = fileName.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        List<String> words = new ArrayList<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] lineWords = line.split(" ");
            for (String s :
                    lineWords) {
                words.add(s);
            }
        }
        fileName.close();
        fileReader.close();

        HashSet<String> notPaired = new HashSet<>();
        for (String s :
                words) {
            if (notPaired.contains(s)) {
                Pair pair = new Pair(s, s);
                result.add(pair);
                notPaired.remove(s);
            } else if (notPaired.contains(new StringBuilder(s).reverse().toString())) {
                String reversed = new StringBuilder(s).reverse().toString();
                Pair pair = new Pair(s, reversed);
                result.add(pair);
                notPaired.remove(reversed);
            } else notPaired.add(s);
        }

        result.forEach(pair -> System.out.println(pair));
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
