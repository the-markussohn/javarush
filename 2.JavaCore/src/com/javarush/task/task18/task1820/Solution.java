package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String notRoundedFile = fileNameReader.readLine();
        String roundedFile = fileNameReader.readLine();

        BufferedReader readFromFirst = new BufferedReader(new FileReader(notRoundedFile));
        FileWriter writeRounded = new FileWriter(roundedFile);
        String number;

        while ((number = readFromFirst.readLine()) != null) {
            long roundedNum = Math.round(Double.parseDouble(number));
            writeRounded.write(String.valueOf(roundedNum) + " ");
        }

        fileNameReader.close();
        readFromFirst.close();
        writeRounded.close();
    }
}
