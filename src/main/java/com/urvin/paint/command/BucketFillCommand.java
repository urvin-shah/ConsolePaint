package com.urvin.paint.command;

import com.urvin.paint.receiver.PaintScreen;
import com.urvin.paint.tool.BucketFill;

public class BucketFillCommand implements IPaintCommand{
    BucketFill bucketFill;

    BucketFillCommand(BucketFill bucketFill) {
        this.bucketFill = bucketFill;
    }
    @Override
    public void execute() {
        PaintScreen.getInstance ().fillColor ( this.bucketFill );
    }
}
