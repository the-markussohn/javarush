package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by Justinas on 2017-10-17.
 */
public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter filepath to the archive:");
        String archiver = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archiver));
        System.out.println("Enter filepath to the file to be archived:");
        String file = reader.readLine();
        zipFileManager.createZip(Paths.get(file));
    }
}
