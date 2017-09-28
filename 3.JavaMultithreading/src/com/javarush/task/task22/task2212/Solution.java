package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;
        return telNumber.matches("\\+[0-9]{12}|\\+[0-9]{2}\\([0-9]{3}\\)\\d{7}|\\+[0-9]{8}-\\d{2}-\\d{2}|[0-9]{6}-[0-9]{4}");
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+370501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
    }
}
