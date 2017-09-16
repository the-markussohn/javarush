package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String file = fileNameReader.readLine();
        BufferedReader contentReader = new BufferedReader(new FileReader(file));

        String[] line;
        while (contentReader.ready()) {
            line = contentReader.readLine().split(" ");
            if (line[0].equals(args[0])) {
                for (int i = 0; i < line.length; i++) {
                    if (i == line.length - 1)
                        System.out.println(line[i]);
                    else
                        System.out.print(line[i] + " ");
                }
            }
        }
        contentReader.close();
    }
}
