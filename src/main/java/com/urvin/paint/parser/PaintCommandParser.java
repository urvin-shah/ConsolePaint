package com.urvin.paint.parser;

import com.urvin.paint.command.*;
import com.urvin.paint.constant.CommandInitialEnum;
import com.urvin.paint.constant.PaintCommandPatternEnum;
import com.urvin.paint.exception.BaseException;
import com.urvin.paint.exception.CommandException;
import com.urvin.paint.tool.BucketFill;
import com.urvin.paint.tool.Canvas;
import com.urvin.paint.tool.Line;
import com.urvin.paint.tool.Rectangle;
import com.urvin.paint.util.ConsoleUtil;

import java.util.HashMap;
import java.util.Map;

public class PaintCommandParser {
    private static PaintCommandParser paintCommandParser;
    private static Map<CommandInitialEnum, PaintCommandPattern> paintPatternCommands;

    private PaintCommandParser() {
        this.paintPatternCommands = new HashMap<> ();
        init ();
    }

    public static PaintCommandParser getInstance() {
        if(paintCommandParser == null) {
            paintCommandParser = new PaintCommandParser ();
        }
        return paintCommandParser;
    }

    public void init() {
        this.paintPatternCommands.put ( CommandInitialEnum.C,new PaintCommandPattern ( PaintCommandPatternEnum.CANVAS ) );
        this.paintPatternCommands.put ( CommandInitialEnum.L,new PaintCommandPattern ( PaintCommandPatternEnum.LINE ) );
        this.paintPatternCommands.put ( CommandInitialEnum.R,new PaintCommandPattern ( PaintCommandPatternEnum.RECTANGLE ) );
        this.paintPatternCommands.put ( CommandInitialEnum.B,new PaintCommandPattern ( PaintCommandPatternEnum.BUCKET_FILL ) );
        this.paintPatternCommands.put ( CommandInitialEnum.Q,new PaintCommandPattern ( PaintCommandPatternEnum.QUIT ) );
    }

    public IPaintCommand parseCommand(String inputCommand) throws BaseException{
        IPaintCommand paintCommand = null;

        PaintCommandPattern commandPattern = paintPatternCommands.get ( CommandInitialEnum.getCommandInitialEnum ( ConsoleUtil.getCommandInitial ( inputCommand )) );
        if(commandPattern != null) {
            if(commandPattern.match ( inputCommand )) {
                String strParams = ConsoleUtil.getParamString ( inputCommand );
                switch (commandPattern.getPattern ()) {
                    case CANVAS:
                            Canvas canvas = new Canvas (strParams);
                            paintCommand = new CreateCanvas ( canvas );
                            break;
                    case LINE:
                            Line line = new Line(strParams);
                            paintCommand = new DrawLine ( line );
                            break;
                    case RECTANGLE:
                            Rectangle rectangle = new Rectangle ( strParams );
                            paintCommand = new DrawRectangle ( rectangle );
                            break;
                    case BUCKET_FILL:
                            BucketFill bucketFill = new BucketFill ( strParams );
                            paintCommand = new BucketFillCommand (bucketFill);
                            break;
                    case QUIT:
                            paintCommand = new QuitCommand ();
                            break;
                    default:
                        throw new CommandException.UnsupportedCommandException ( "Invalid Command" ) ;
                }

            } else {
                throw new CommandException.UnsupportedFormatException ( "Invalid Command format, Please enter valid format." );
            }
        }else {
            throw new CommandException.UnsupportedCommandException ("Invalid command, This command is not supported by this application");
        }

        return paintCommand;
    }
}
