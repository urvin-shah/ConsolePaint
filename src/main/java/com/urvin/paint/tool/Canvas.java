package com.urvin.paint.tool;

import java.util.Objects;

public class Canvas {
    private int width;
    private int height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Canvas)) return false;
        Canvas canvas = (Canvas) o;
        return width == canvas.width &&
                height == canvas.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash ( width, height );
    }
}
