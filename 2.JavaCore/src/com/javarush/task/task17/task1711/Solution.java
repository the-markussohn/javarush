package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat outDateFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[i + 1].equals(Sex.FEMALE.getSex())) {
                            allPeople.add(Person.createFemale(args[i], simpleDateFormat.parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        } else {
                            allPeople.add(Person.createMale(args[i], simpleDateFormat.parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        Person personToUpdate = allPeople.get(Integer.parseInt(args[i]));
                        personToUpdate.setName(args[i + 1]);
                        if (args[i + 2].equals("ж"))
                            personToUpdate.setSex(Sex.FEMALE);
                        else
                            personToUpdate.setSex(Sex.MALE);
                        personToUpdate.setBirthDay(simpleDateFormat.parse(args[i + 3]));
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person personToDelete = allPeople.get(Integer.parseInt(args[i]));
                        personToDelete.setName(null);
                        personToDelete.setSex(null);
                        personToDelete.setBirthDay(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(person.getName() + " " + person.getSex().getSex() + " " + outDateFormat.format(person.getBirthDay()));
                    }
                }
                break;
        }
    }
}
