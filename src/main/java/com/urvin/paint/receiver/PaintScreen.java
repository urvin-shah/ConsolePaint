package com.urvin.paint.receiver;

import com.urvin.paint.exception.CommandException;
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
        this.screen = new char[canvas.getHeight ()+2][canvas.getWidth ()+2];
        this.initializeScreen ();
    }

    public static PaintScreen getInstance(Canvas canvas) {
        paintScreen = new PaintScreen ( canvas );
        return paintScreen;
    }

    public static PaintScreen getInstance() {
        return paintScreen;
    }

    private void initializeScreen() {
        IntStream.range(0, screen.length).forEach(x ->
                IntStream.range(0, screen[0].length)
                        .forEach(y -> screen[x][y] = ' ')
        );
    }

    public void drawCanvas(Canvas canvas,char horizontalLineSymbol,char verticalLineSymbol) throws CommandException.InvalidCommandParamsException {
        this.drawRectangle ( new Rectangle ( 0,0,canvas.getWidth ()+1,canvas.getHeight ()+1 ),horizontalLineSymbol,verticalLineSymbol );
    }

    public void drawLine(Line line,char lineSymbol) throws CommandException.InvalidCommandParamsException{
        if (!isValidLine ( line )) {
            throw new CommandException.InvalidCommandParamsException ( "Invalid Command Parameters" );
        }
        IntStream.rangeClosed ( line.getY1 (), line.getY2 () ).forEach ( y ->
                IntStream.rangeClosed ( line.getX1 (), line.getX2 () )
                        .forEach ( x -> {
                            this.screen[y][x] = lineSymbol;
                        } )
        );
    }

    public void drawRectangle(Rectangle rectangle,char horizontalLineSymbol,char verticalLineSymbol) throws CommandException.InvalidCommandParamsException{
         this.drawLine(new Line(rectangle.getX1 (), rectangle.getY1 (), rectangle.getX1 (), rectangle.getY2 ()), verticalLineSymbol);
         this.drawLine(new Line(rectangle.getX2 (), rectangle.getY1 (), rectangle.getX2 (), rectangle.getY2 ()), verticalLineSymbol);
         this.drawLine(new Line(rectangle.getX1 (), rectangle.getY2 (), rectangle.getX2 (), rectangle.getY2 ()), horizontalLineSymbol);
         this.drawLine(new Line(rectangle.getX1 (), rectangle.getY1 (), rectangle.getX2 (), rectangle.getY1 ()), horizontalLineSymbol);
    }

    public void fillColor(BucketFill bucketFill) throws CommandException.InvalidCommandParamsException{
        if(isValidBucketFill ( bucketFill.getX (),bucketFill.getY () )){
            IntStream.range ( 1,screen.length-1 ).forEach ( x->
                    IntStream.range ( 1,screen[0].length-1 ).forEach ( y->{
                        if(screen[x][y] == ' ') {
                            screen[x][y] = bucketFill.getColor ();
                        }
                    } ));
        } else {
            throw new CommandException.InvalidCommandParamsException ( "Invalid BucketFill Paramters" );
        }
    }

    public void drawScreen() {
        String screenStr = Arrays.stream(screen)
                .map(String::valueOf)
                .collect( Collectors.toList())
                .stream()
                .collect( Collectors.joining(System.lineSeparator()));

        System.out.println (screenStr);
    }

    public void quit() {
        System.exit ( 1 );
    }

    private boolean isValidLine(Line line) {
        if(line.getX1 () < screen[0].length &&
                line.getY1 () < screen.length &&
                line.getX2 () < screen[0].length &&
                line.getY2 () < screen.length) {
            return true;
        }
        return false;
    }

    private boolean isValidBucketFill(int x,int y) {
        if(x < screen[0].length && y<screen.length) {
            return true;
        }
        return false;
    }

    public char[][] getScreen() {
        return screen;
    }
}