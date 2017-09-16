package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = fileNameReader.readLine();
        String file2 = fileNameReader.readLine();
        String file3 = fileNameReader.readLine();

        FileOutputStream fileWriter = new FileOutputStream(file1);
        FileInputStream secondFileReader = new FileInputStream(file2);
        FileInputStream thirdFileReader = new FileInputStream(file3);

        while (secondFileReader.available() > 0) {
            fileWriter.write(secondFileReader.read());
        }

        while (thirdFileReader.available() > 0) {
            fileWriter.write(thirdFileReader.read());
        }

        fileNameReader.close();
        fileWriter.close();
        secondFileReader.close();
        thirdFileReader.close();
    }
}
