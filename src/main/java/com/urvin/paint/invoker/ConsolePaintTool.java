package com.urvin.paint.invoker;

import com.urvin.paint.command.IPaintCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * ConsolePaintTool is a invoker class.
 */
public class ConsolePaintTool {

    List<IPaintCommand> lstPaintCommands;

    public ConsolePaintTool() {
        this.lstPaintCommands = new ArrayList<> ();
    }

    /**
     * execute method will be called for the command, it keeps tracke of past executed commands as well.
     * @param command
     */
    public void execute(IPaintCommand command) {
        lstPaintCommands.add ( command );
        command.execute ();
    }
}