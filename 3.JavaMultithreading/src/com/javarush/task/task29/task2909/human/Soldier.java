package com.javarush.task.task29.task2909.human;

/**
 * Created by Justinas on 2017-10-15.
 */
public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void fight() {
    }

    public void live() {
        fight();
    }

}
