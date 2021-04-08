package com.urvin.paint.tool;

import java.util.Objects;

public class Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return x1 == rectangle.x1 &&
                y1 == rectangle.y1 &&
                x2 == rectangle.x2 &&
                y2 == rectangle.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash ( x1, y1, x2, y2 );
    }
}
