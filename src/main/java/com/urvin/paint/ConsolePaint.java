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
    public void startDrawing() {
        Scanner scanner = new Scanner ( System.in );
        String strCommand = null;
        IPaintCommand paintCommand=null;
        while(true) {
            System.out.print ("Please Enter Paint Command:");
             strCommand = scanner.nextLine ();
             try {
                 paintCommand = paintCommandParser.parseCommand ( strCommand );
                 consolePaintTool.execute ( paintCommand );
             }catch (BaseException e) {
                 e.printMessage ();
             }
            System.out.println ();
        }
    }
}
