package com.urvin.paint.parser;

import com.urvin.paint.command.IPaintCommand;

public class PaintCommandPattern {
    private String pattern;
    private IPaintCommand paintCommand;
    private Character commandSymbol;

    public PaintCommandPattern(String pattern, IPaintCommand paintCommand) {
        this.pattern = pattern;
        this.paintCommand = paintCommand;
        this.commandSymbol = pattern.charAt ( 0 );
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public IPaintCommand getPaintCommand() {
        return paintCommand;
    }

    public void setPaintCommand(IPaintCommand paintCommand) {
        this.paintCommand = paintCommand;
    }

    public char getCommandSymbol() {
        return commandSymbol;
    }

    public void setCommandSymbol(char commandSymbol) {
        this.commandSymbol = commandSymbol;
    }
}
