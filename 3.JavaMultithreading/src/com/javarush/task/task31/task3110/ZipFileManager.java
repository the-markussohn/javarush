package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Justinas on 2017-10-17.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        try (ZipOutputStream outputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             InputStream inputStream = Files.newInputStream(source)) {
            ZipEntry entry = new ZipEntry(String.valueOf(source.getFileName()));
            outputStream.putNextEntry(entry);
            while (inputStream.available() > 0) {
                outputStream.write(inputStream.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
