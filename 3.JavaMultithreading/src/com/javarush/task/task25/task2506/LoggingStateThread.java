package com.javarush.task.task25.task2506;

/**
 * Created by Justinas on 2017-10-05.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;
    private State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.state = thread.getState();
        this.setDaemon(true);
        printState(state);
    }

    private void printState(State state) {
        System.out.println(state);
    }

    @Override
    public void run() {
        while (thread.getState() != State.TERMINATED) {
            if (!state.equals(thread.getState())) {
                this.state = thread.getState();
                printState(state);
            }
        }
    }
}
