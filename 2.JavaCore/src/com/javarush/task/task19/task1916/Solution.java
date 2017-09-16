package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = fileNameReader.readLine();
        String file2 = fileNameReader.readLine();

        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);
        BufferedReader fileReader1 = new BufferedReader(fr1);
        BufferedReader fileReader2 = new BufferedReader(fr2);
        List<String> fileOneStrings = new ArrayList<>();
        List<String> fileTwoStrings = new ArrayList<>();

        while (fileReader1.ready()) {
            fileOneStrings.add(fileReader1.readLine());
        }

        while (fileReader2.ready()) {
            fileTwoStrings.add(fileReader2.readLine());
        }

        for (int i = 0; i < fileOneStrings.size(); i++) {
            if (i < fileTwoStrings.size() && fileOneStrings.get(i).equals(fileTwoStrings.get(i))) {
                lines.add(new LineItem(Type.SAME, fileOneStrings.get(i)));
                if (i == fileOneStrings.size() - 1 && fileTwoStrings.size() > fileOneStrings.size())
                    lines.add(new LineItem(Type.ADDED, fileTwoStrings.get(i + 1)));
                fileOneStrings.remove(i);
                fileTwoStrings.remove(i);
                i--;
            } else if ((i + 1 < fileTwoStrings.size() && fileOneStrings.get(i).equals(fileTwoStrings.get(i + 1))) && (i + 1 >= fileOneStrings.size() || !fileOneStrings.get(i + 1).equals(fileTwoStrings.get(i)))) {
                lines.add(new LineItem(Type.ADDED, fileTwoStrings.get(i)));
                fileTwoStrings.remove(i);
                i--;
            } else {
                lines.add(new LineItem(Type.REMOVED, fileOneStrings.get(i)));
                fileOneStrings.remove(i);
                i--;
            }
        }

        fileNameReader.close();
        fr1.close();
        fr2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
