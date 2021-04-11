package com.urvin.paint.command;

import com.urvin.paint.exception.CommandException;
import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.BucketFill;

public class BucketFillCommand implements IPaintCommand{
    BucketFill bucketFill;

    public BucketFillCommand(BucketFill bucketFill) {
        this.bucketFill = bucketFill;
    }
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
