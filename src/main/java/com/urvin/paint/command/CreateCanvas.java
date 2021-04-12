package com.urvin.paint.command;

import com.urvin.paint.constant.DrawingSymbol;
import com.urvin.paint.exception.CommandException;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.Canvas;

public class CreateCanvas implements IPaintCommand {
    private Canvas canvas;
    public CreateCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * This command will draw the canvas.
     * It will create the canvas which can be used later on for drawing other shapes.     *
     */
    @Override
    public void execute() {
        PaintScreen paintScreen = PaintScreen.getInstance(this.canvas) ;
        try {
            paintScreen.drawCanvas ( canvas, DrawingSymbol.CANVAS_HORIZONTAL_SYMBOL.getDrawingSymbol (),DrawingSymbol.CANVAS_VERTICAL_SYMBOL.getDrawingSymbol () );
            paintScreen.drawScreen ();
        }catch (CommandException.InvalidCommandParamsException ive) {
            ive.printMessage ();
        }
    }
}
