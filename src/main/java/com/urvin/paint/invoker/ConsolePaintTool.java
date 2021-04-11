package com.urvin.paint.invoker;

import com.urvin.paint.command.IPaintCommand;

import java.util.ArrayList;
import java.util.List;

public class ConsolePaintTool {

    List<IPaintCommand> lstPaintCommands;

    public ConsolePaintTool() {
        this.lstPaintCommands = new ArrayList<> ();
    }

    public void execute(IPaintCommand command) {
        lstPaintCommands.add ( command );
        command.execute ();
    }
}