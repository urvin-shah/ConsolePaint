package com.urvin.paint.receiver;

import com.urvin.paint.tool.BucketFill;
import com.urvin.paint.tool.Canvas;
import com.urvin.paint.tool.Line;
import com.urvin.paint.tool.Rectangle;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaintScreen {
    private final char[][] screen;
    static PaintScreen paintScreen = null;

    private PaintScreen(Canvas canvas) {
        this.screen = new char[canvas.getWidth ()+2][canvas.getHeight ()+2];
        this.initializeScree ();
    }

    public static PaintScreen getInstance(Canvas canvas) {
        if(paintScreen == null) {
            paintScreen = new PaintScreen ( canvas );
        }
        return paintScreen;
    }

    public static PaintScreen getInstance() {
        return paintScreen;
    }

    private void initializeScree() {
        IntStream.range(0, screen.length).forEach(x ->
                IntStream.range(0, screen[0].length)
                        .forEach(y -> screen[x][y] = ' ')
        );
    }

    public void drawCanvas(Canvas canvas,char horizontalLineSymbol,char verticalLineSymbol) {
        this.drawRectangle ( new Rectangle ( 0,0,canvas.getWidth ()+1,canvas.getHeight ()+1 ),horizontalLineSymbol,verticalLineSymbol );
        this.drawScreen ();
    }

    public void drawLine(Line line,char lineSymbol) {
        System.out.println (lineSymbol);
        System.out.println ("Arraysize"+screen.length+" "+screen[0].length);
        System.out.println ("x1,y1,x2,y2:"+line.getX1 ()+","+line.getY1 ()+","+line.getX2 ()+","+line.getY2 ());
        IntStream.rangeClosed(line.getY1 (), line.getY2 ()).forEach( y ->
                IntStream.rangeClosed(line.getX1 (), line.getX2 ())
                        .forEach(x -> {
                            screen[x][y] = lineSymbol;
                            //System.out.print (screen[x][y]);
                        })
        );
        /*for(int i=line.getX1 ();i<line.getX2 ();i++) {
            for(int j=line.getY1 ();j<line.getY2 ();j++) {
                this.screen[i][j] = lineSymbol;
                System.out.print(this.screen[i][j]);
            }
        }*/
    }

    public void drawRectangle(Rectangle rectangle,char horizontalLineSymbol,char verticalLineSymbol) {
         this.drawLine(new Line(rectangle.getX1 (), rectangle.getY1 (), rectangle.getX1 (), rectangle.getY2 ()), horizontalLineSymbol);
         this.drawLine(new Line(rectangle.getX2 (), rectangle.getY1 (), rectangle.getX2 (), rectangle.getY2 ()), horizontalLineSymbol);
         this.drawLine(new Line(rectangle.getX1 (), rectangle.getY2 (), rectangle.getX2 (), rectangle.getY2 ()), verticalLineSymbol);
         this.drawLine(new Line(rectangle.getX1 (), rectangle.getY1 (), rectangle.getX2 (), rectangle.getY1 ()), verticalLineSymbol);
    }

    public void fillColor(BucketFill bucketFill) {

    }

    public void drawScreen() {
        String screenStr = Arrays.stream(screen)
                .map(String::valueOf)
                .collect( Collectors.toList())
                .stream()
                .collect( Collectors.joining(System.lineSeparator()));
        /*for(int i=0;i<screen.length;i++) {
            for(int j=0;j<screen[0].length;j++) {
                System.out.print (this.screen[i][j]);
            }
            System.out.println ();
        }*/
        System.out.println (screenStr);
    }

    public void quit() {
        System.exit ( 1 );
    }
}
