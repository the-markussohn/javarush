package com.javarush.task.task24.task2413;

/**
 * Created by Justinas on 2017-10-04.
 */
public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    public void draw(Canvas canvas) {
        
    }

    @Override
    public void move() {
        x += speed * direction;
    }

    public void moveRight() {
        direction = 1;
    }

    public void moveLeft() {
        direction = -1;
    }
}
