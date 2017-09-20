package com.javarush.task.task20.task2025;

import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> results = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N)));
        result = new long[results.size()];
        for (int i = 0; i < results.size(); i++) {
            result[i] = results.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        long[] result = getNumbers(10000);
        for (long l :
                result) {
            System.out.println(l);
        }
    }
}
