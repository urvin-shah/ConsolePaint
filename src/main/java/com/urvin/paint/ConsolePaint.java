package com.urvin.paint;

import com.urvin.paint.command.IPaintCommand;
import com.urvin.paint.exception.BaseException;
import com.urvin.paint.invoker.ConsolePaintTool;
import com.urvin.paint.parser.PaintCommandParser;

import java.util.Scanner;

public class ConsolePaint {
    PaintCommandParser paintCommandParser;
    ConsolePaintTool consolePaintTool;

    public ConsolePaint() {
        paintCommandParser = PaintCommandParser.getInstance ();
        consolePaintTool = new ConsolePaintTool ();
    }
    public void startDrawing(String strCommand) {
        IPaintCommand paintCommand=null;
        try {
             paintCommand = paintCommandParser.parseCommand ( strCommand );
             consolePaintTool.execute ( paintCommand );
         }catch (BaseException e) {
             e.printMessage ();
         }
        System.out.println ();
    }
}