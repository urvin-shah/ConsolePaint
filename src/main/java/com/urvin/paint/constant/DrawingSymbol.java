package com.urvin.paint.constant;

/**
 * DrawingSymbol is an Enum which has the symbol used in the application.
 * By changing the symbol will reflect to the application.
 */
public enum DrawingSymbol {

    CANVAS_HORIZONTAL_SYMBOL('-'),
    CANVAS_VERTICAL_SYMBOL ('|'),
    RECTANGLE ('x'),
    LINE('x'),
    EMPTY(' ');

    private char drawingSymbol;

    /**
     * This is a constructor to set the drawing symbol
     * @param drawingSymbol
     */
    DrawingSymbol(char drawingSymbol) {
        this.drawingSymbol = drawingSymbol;
    }

    /**
     * This method returns the drawing symbol of given constant.
     * @return
     */
    public char getDrawingSymbol() {
        return drawingSymbol;
    }
}
