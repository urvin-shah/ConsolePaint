package com.urvin.paint.command;

import com.urvin.paint.constant.DrawingSymbol;
import com.urvin.paint.exception.CommandException;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.Rectangle;

public class DrawRectangle implements IPaintCommand {
    private Rectangle rectangle;
    public DrawRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * This command will draw the Rectangle
     * It will validate whether co-ordinate are inside the canvas or not.
     * If appropriate then draws a rectangle in the canvas with the given color-char else it gives error message.
     */
    @Override
    public void execute() {
        PaintScreen paintScreen = PaintScreen.getInstance ();
        try {
            paintScreen.drawRectangle ( rectangle, DrawingSymbol.RECTANGLE.getDrawingSymbol (), DrawingSymbol.RECTANGLE.getDrawingSymbol () );
            paintScreen.fillRectangle ( rectangle );
            paintScreen.drawScreen ();
            paintScreen.addRectangle ( rectangle );
        }catch (CommandException.InvalidCommandParamsException ive) {
            ive.printMessage ();
        }
    }
}
