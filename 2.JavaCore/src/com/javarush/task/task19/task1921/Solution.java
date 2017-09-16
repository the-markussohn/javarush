package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader fileReader = new BufferedReader(fr);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

        String line;

        while ((line = fileReader.readLine()) != null) {
            String[] parts = line.split(" ");
            String name = "";
            Date bDay = sdf.parse(parts[parts.length - 3] + " " + parts[parts.length - 2] + " " + parts[parts.length - 1]);
            int nameParts = parts.length - 3;
            for (int i = 0; i < nameParts; i++) {
                name += parts[i] + " ";
            }
            PEOPLE.add(new Person(name.trim(), bDay));
        }

        fr.close();
    }
}
