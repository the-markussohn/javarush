package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] digits = br.readLine().split("");
        for (String digit :
                digits) {
            if (integerOfString(digit) % 2 == 0)
                even += 1;
            else
                odd += 1;
        }
        System.out.println(String.format("Even: %d Odd: %d", even, odd));
    }

    private static int integerOfString(String digit) {
        return Integer.parseInt(digit);
    }
}
