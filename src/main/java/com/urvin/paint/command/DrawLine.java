package com.urvin.paint.command;

import com.urvin.paint.constant.DrawingSymbol;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.Line;

public class DrawLine implements IPaintCommand{

    private Line line;
    public DrawLine(Line line) {
        this.line = line;
    }
    @Override
    public void execute() {
        PaintScreen paintScreen = PaintScreen.getInstance (  );
        paintScreen.drawLine ( this.line, DrawingSymbol.LINE.getDrawingSymbol () );
    }
}
