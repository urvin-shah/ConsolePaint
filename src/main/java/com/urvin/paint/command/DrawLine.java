package com.urvin.paint.command;

import com.urvin.paint.constant.DrawingSymbol;
import com.urvin.paint.exception.CommandException;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.Line;

public class DrawLine implements IPaintCommand{

    private Line line;
    public DrawLine(Line line) {
        this.line = line;
    }

    /**
     * This command will draw a line inside the Canvas.
     * It will validate whether co-ordinates of line are inside the canvas or not.
     * If appropriate then it draws a line in the canvas with the given color-char else it gives error message.
     */
    @Override
    public void execute() {
        PaintScreen paintScreen = PaintScreen.getInstance (  );
        try {
            paintScreen.drawLine ( this.line, DrawingSymbol.LINE.getDrawingSymbol () );
            paintScreen.drawScreen ();
        }catch (CommandException.InvalidCommandParamsException ive) {
            ive.printMessage ();
        }
    }
}
