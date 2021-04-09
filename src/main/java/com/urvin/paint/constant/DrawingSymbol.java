package com.urvin.paint.constant;

public enum DrawingSymbol {

    CANVAS_HORIZONTAL_SYMBOL('-'),
    CANVAS_VERTICAL_SYMBOL ('|'),
    RECTANGLE ('x'),
    LINE('x'),
    BUCKET_FILL('*');

    private char drawingSymbol;

    DrawingSymbol(char drawingSymbol) {
        this.drawingSymbol = drawingSymbol;
    }

    public char getDrawingSymbol() {
        return drawingSymbol;
    }
}
