package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);
        Charset win1251 = Charset.forName("Windows-1251");
        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);
        String s = new String(buffer, Charset.defaultCharset());
        outputStream.write(s.getBytes(win1251));
        inputStream.close();
        outputStream.close();
    }
}
