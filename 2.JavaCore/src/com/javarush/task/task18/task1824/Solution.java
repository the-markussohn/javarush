package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            while (true) {
                fileName = fileNameReader.readLine();
                FileInputStream fileReader = new FileInputStream(fileName);
                fileReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        }
    }
}
