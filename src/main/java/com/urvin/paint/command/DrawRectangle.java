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
    @Override
    public void execute() {
        PaintScreen paintScreen = PaintScreen.getInstance ();
        try {
            paintScreen.drawRectangle ( rectangle, DrawingSymbol.RECTANGLE.getDrawingSymbol (), DrawingSymbol.RECTANGLE.getDrawingSymbol () );
            paintScreen.drawScreen ();
        }catch (CommandException.InvalidCommandParamsException ive) {
            ive.printMessage ();
        }
    }
}
