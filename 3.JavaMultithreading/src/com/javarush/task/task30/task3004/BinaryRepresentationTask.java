package com.javarush.task.task30.task3004;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Justinas on 2017-10-14.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int remainder = x % 2;
        int num = x / 2;
        String result = String.valueOf(remainder);
        if (num > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(num);
            task.fork();
            return task.join() + result;
        }
        return result;
    }
}
