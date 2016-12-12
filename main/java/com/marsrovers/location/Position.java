package com.marsrovers.location;

public class Position {

    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position moveX(int amount) {
        return new Position(x + amount, y);
    }

    public Position moveY(int amount) {
        return new Position(x, y + amount);
    }

    @Override
    public String toString() {
        return x + ", " +  y;
    }
}
