package com.urvin.paint.command;

import com.urvin.paint.constant.DrawingSymbol;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.Canvas;

public class CreateCanvas implements IPaintCommand {
    private Canvas canvas;
    public CreateCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void execute() {
        PaintScreen paintScreen = PaintScreen.getInstance(this.canvas) ;
        System.out.println ("Canvas Horizontal Symbol:"+DrawingSymbol.CANVAS_HORIZONTAL_SYMBOL.getDrawingSymbol ());
        System.out.println ("Canvas Vertical Symbol:"+DrawingSymbol.CANVAS_VERTICAL_SYMBOL.getDrawingSymbol ());
        paintScreen.drawCanvas ( canvas, DrawingSymbol.CANVAS_HORIZONTAL_SYMBOL.getDrawingSymbol (),DrawingSymbol.CANVAS_VERTICAL_SYMBOL.getDrawingSymbol () );
    }
}
