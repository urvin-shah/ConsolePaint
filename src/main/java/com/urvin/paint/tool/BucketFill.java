package com.urvin.paint.tool;

import java.util.Objects;

public class BucketFill {
    private int x;
    private int y;
    private char color;

    public BucketFill(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BucketFill)) return false;
        BucketFill that = (BucketFill) o;
        return x == that.x &&
                y == that.y &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash ( x, y, color );
    }
}
