package com.urvin.paint.command;

import com.urvin.paint.exception.CommandException;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.BucketFill;

public class BucketFillCommand implements IPaintCommand{
    BucketFill bucketFill;

    public BucketFillCommand(BucketFill bucketFill) {
        this.bucketFill = bucketFill;
    }

    /**
     * This command will fill the color with the given color-char in the command in the canvas.
     * It will validate whether co-ordinate are inside the canvas or not.
     * If appropriate then fill the canvas with the given color-char else it gives error message.
     */
    @Override
    public void execute() {
        try {
            PaintScreen.getInstance ().fillColor ( this.bucketFill );
            PaintScreen.getInstance ().drawScreen ();
        }catch (CommandException.InvalidCommandParamsException ive) {
            ive.printMessage ();
        }
    }
}
