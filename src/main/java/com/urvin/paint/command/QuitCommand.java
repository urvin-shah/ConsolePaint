package com.urvin.paint.command;

import com.urvin.paint.receiver.PaintScreen;

public class QuitCommand implements IPaintCommand{
    @Override
    public void execute() {
        PaintScreen.getInstance ().quit ();
    }
}