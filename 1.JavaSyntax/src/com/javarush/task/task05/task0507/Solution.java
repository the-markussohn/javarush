package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            String s = bufferedReader.readLine();
            if (s.equals("-1"))
                break;
            numbers.add(Integer.parseInt(s));
        }
        System.out.println((double)sumOfList(numbers)/numbers.size());
    }

    private static int sumOfList(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num :
                numbers) {
            sum += num;
        }
        return sum;
    }
}

