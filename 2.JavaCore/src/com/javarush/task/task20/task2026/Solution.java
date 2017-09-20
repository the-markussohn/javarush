package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int counter = 0, temp_j = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = temp_j; j < a.length; j++) {
                if (a[i][j] == 1) {
                    counter++;
                    int temp_i = i;
                    while (i < a.length && a[i][j] == 1) {
                        i++;
                    }
                    while (j < a.length && a[temp_i][j] == 1) {
                        j++;
                    }
                    if (i == a.length && j < a.length){
                        i = temp_i;
                        temp_j = j;
                    }
                    j--;
                }
            }
        }
        return counter;
    }
}
