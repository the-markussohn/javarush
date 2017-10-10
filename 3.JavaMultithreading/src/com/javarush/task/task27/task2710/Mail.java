package com.javarush.task.task27.task2710;

public class Mail {
    private String text;

    public String getText() throws InterruptedException {
        while (text == null)
            this.wait();
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.notify();
    }
}
