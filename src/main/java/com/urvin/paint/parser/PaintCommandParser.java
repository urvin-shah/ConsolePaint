package com.urvin.paint.parser;

import com.urvin.paint.command.CreateCanvasCommand;
import com.urvin.paint.command.IPaintCommand;

import java.util.HashMap;
import java.util.Map;

public class PaintCommandParser {
    Map<PaintCommandPatterEnum, IPaintCommand> paintPatternCommands;

    public PaintCommandParser() {
        this.paintPatternCommands = new HashMap<> ();
    }

    public void init() {
        this.paintPatternCommands.put ( PaintCommandPatterEnum.CANVAS, new CreateCanvasCommand(int w,int h) );
    }
}
