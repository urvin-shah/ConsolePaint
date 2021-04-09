package com.urvin.paint;

import com.urvin.paint.command.CreateCanvas;
import com.urvin.paint.tool.Canvas;

public class Application {
    public static void main(String[] args) {
        Canvas canvas = new Canvas ( 20,20 );
        CreateCanvas createCanvas = new CreateCanvas ( canvas );
        createCanvas.execute ();

    }
}
