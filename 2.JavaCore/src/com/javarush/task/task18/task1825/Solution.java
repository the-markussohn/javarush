package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, byte[]> fileParts = new TreeMap<>();
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        while (!(fileName = fileNameReader.readLine()).equals("end")) {
            FileInputStream readFromPart = new FileInputStream(fileName);
            byte[] fileBytes = new byte[(int) readFromPart.getChannel().size()];
            readFromPart.read(fileBytes);
            fileParts.put(fileName, fileBytes);
            readFromPart.close();
        }

        String mainFile = fileParts.firstKey().substring(0, fileParts.firstKey().lastIndexOf("."));
        FileOutputStream writeToMainFile = new FileOutputStream(mainFile);

        fileParts.forEach((k, v) -> {
            try {
                writeToMainFile.write(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writeToMainFile.close();
    }
}
