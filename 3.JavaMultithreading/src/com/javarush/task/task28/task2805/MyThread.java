package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Justinas on 2017-10-11.
 */
public class MyThread extends Thread {
    private static AtomicInteger priority = new AtomicInteger(Thread.MIN_PRIORITY);

    public MyThread() {
        setPriority();
    }

    private void setPriority() {
        if (priority.get() < Thread.MAX_PRIORITY) setPriority(priority.getAndIncrement());
        else setPriority(priority.getAndSet(Thread.MIN_PRIORITY));
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }
}
