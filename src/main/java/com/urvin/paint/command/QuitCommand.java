package com.urvin.paint.command;

import com.urvin.paint.receiver.PaintScreen;

public class QuitCommand implements IPaintCommand{
    /**
     * This command will quit the running application.
     */
    @Override
    public void execute() {
        PaintScreen.getInstance ().quit ();
    }
}