package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String input = args[0];
            if (!input.matches("[A-Za-z0-9]+")) {
                System.out.println("incorrect");
            } else {
                for (int i = 2; i < 37; i++) {
                    try {
                        BigDecimal bi = new BigDecimal(new BigInteger(input, i));
                        System.out.println(i);
                        i = 37;
                    } catch (Exception e) {

                    }
                }
            }
        } catch (Exception e) {
        }
    }
}