package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = File.createTempFile("my_file", ".ser");
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        Solution savedObject = new Solution(4);
        os.writeObject(savedObject);
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
        Solution loadedObject = new Solution(16);
        loadedObject = (Solution) is.readObject();
        is.close();
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
