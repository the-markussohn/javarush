package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int median = getMedian(array);
        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o1 - median), Math.abs(o2 - median));
            }
        };
        Arrays.sort(array, compareByMedian);
        return array;
    }

    private static int getMedian(Integer[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0)
            return (array[array.length / 2] + array[array.length / 2 - 1])/2;
        else
            return array[array.length / 2];
    }
}
