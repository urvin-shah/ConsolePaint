package com.urvin.paint.tool;

import com.urvin.paint.util.ConsoleUtil;

import java.util.Objects;

public class Canvas {
    private int width;
    private int height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Canvas(String input) {
        String[] params = input.split ( " " );
        if(params != null) {
            this.width = ConsoleUtil.getInt ( params[0] );
            this.height = ConsoleUtil.getInt ( params[1] );
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
