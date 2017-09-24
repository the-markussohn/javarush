package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        params.forEach((k, v) -> {
            if (v != null && k != null)
                sb
                        .append(k)
                        .append(" = '")
                        .append(v)
                        .append("'" + " and ");
        });
        if (sb.toString().equals(""))
            return sb.toString();
        return sb.substring(0, sb.length() - 5);
    }
}
