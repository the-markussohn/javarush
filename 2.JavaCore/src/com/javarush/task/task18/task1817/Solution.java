package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String fileContent = "";
        String line = null;
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                fileContent += line;
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String noWhiteSpace = fileContent.replaceAll("\\s+", "");
        System.out.println(String.format("%.2f", (double) (fileContent.length() - noWhiteSpace.length())/fileContent.length()*100));
    }
}
