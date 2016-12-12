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

    @Override
    public boolean equals(Object o) {
        Position that = (Position) o;
        return that.x == x && that.y == y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
