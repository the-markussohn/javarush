package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = fileNameReader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        private FileInputStream fileReader;
        private String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            fileReader = new FileInputStream(fileName);
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            Map<Integer, Integer> bytesFrequency = new HashMap<>();
            try {
                while (fileReader.available() > 0) {
                    int ch = fileReader.read();
                    if (bytesFrequency.containsKey(ch))
                        bytesFrequency.put(ch, bytesFrequency.get(ch) + 1);
                    else
                        bytesFrequency.put(ch, 1);
                }
                Map.Entry<Integer, Integer> maxEntry = null;
                for (Map.Entry<Integer, Integer> entry :
                        bytesFrequency.entrySet()) {
                    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                        maxEntry = entry;
                }
                resultMap.put(fileName, maxEntry.getKey());
                fileReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
