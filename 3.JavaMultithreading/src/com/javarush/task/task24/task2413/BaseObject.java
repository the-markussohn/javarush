package com.javarush.task.task24.task2413;

/**
 * Created by Justinas on 2017-10-04.
 */
public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean isIntersec(BaseObject o) {
        return Math.sqrt(Math.pow(x - o.getX(), 2) + Math.pow(y - o.getY(), 2)) <= Math.max(radius, o.getRadius());
    }
}
