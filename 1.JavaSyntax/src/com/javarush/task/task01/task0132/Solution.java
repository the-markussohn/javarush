package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String digits[] = String.valueOf(number).split("");
        int sum = 0;
        for (String digit :
                digits) {
            sum += Integer.parseInt(digit);
        }
        return sum;
    }
}