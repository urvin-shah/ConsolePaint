package com.urvin.paint.receiver;

import com.urvin.paint.command.BucketFillCommand;
import com.urvin.paint.command.CreateCanvas;
import com.urvin.paint.command.DrawLine;
import com.urvin.paint.command.DrawRectangle;
import com.urvin.paint.constant.DrawingSymbol;
import com.urvin.paint.exception.CommandException;
import com.urvin.paint.tool.BucketFill;
import com.urvin.paint.tool.Canvas;
import com.urvin.paint.tool.Line;
import com.urvin.paint.tool.Rectangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaintScreenTest {

    PaintScreen paintScreen;

    @BeforeEach
    void init() throws CommandException.InvalidCommandParamsException{
        Canvas canvas = new Canvas ( "5 5" );
        paintScreen = PaintScreen.getInstance (canvas);
        paintScreen.drawCanvas ( canvas,'-','|' );
    }

    @Test
    @DisplayName ( "Draw Canvas success" )
    void drawCanvasSuccess()  {
        char[][] actual = paintScreen.getScreen ();
        assertNotNull ( actual );
        assertEquals ( '-',actual[0][0] );
        assertEquals ( '-',actual[0][1] );
        assertEquals ( '|',actual[1][0] );
    }

    @Test
    @DisplayName ( "Draw Line Success" )
    void drawLineSuccess() throws CommandException.InvalidCommandParamsException{
        Line line = new Line ( "1 1 1 4" );
        paintScreen.drawLine ( line,'x' );
        char[][] actual = paintScreen.getScreen ();
        assertNotNull ( actual );
        assertEquals ( 'x',actual[1][1] );
        assertEquals ( 'x',actual[2][1] );
        assertEquals ( 'x',actual[3][1] );
        assertEquals ( 'x',actual[4][1] );
    }

    @Test
    void drawRectangle() throws CommandException.InvalidCommandParamsException{
        Rectangle rectangle = new Rectangle ( "1 1 4 4" );
        paintScreen.drawRectangle ( rectangle,'x','x' );
        char[][] actual = paintScreen.getScreen ();
        assertNotNull ( actual );
        assertEquals ( 'x',actual[1][1] );
        assertEquals ( 'x',actual[2][1] );
        assertEquals ( 'x',actual[3][1] );
        assertEquals ( 'x',actual[4][1] );

        assertEquals ( 'x',actual[1][2] );
        assertEquals ( 'x',actual[1][3] );
        assertEquals ( 'x',actual[1][4] );
    }

    @Test
    void fillColor() throws CommandException.InvalidCommandParamsException{
        BucketFill bucketFill = new BucketFill ( "2 2 o" );
        paintScreen.fillColor ( bucketFill );
        char[][] actual = paintScreen.getScreen ();
        assertNotNull ( actual );
        assertEquals ( 'o',actual[1][1] );
        assertEquals ( 'o',actual[2][1] );
        assertEquals ( 'o',actual[3][1] );
        assertEquals ( 'o',actual[4][1] );

        assertEquals ( 'o',actual[1][2] );
        assertEquals ( 'o',actual[1][3] );
        assertEquals ( 'o',actual[1][4] );

        assertEquals ( 'o',actual[2][2] );
        assertEquals ( 'o',actual[3][2] );
        assertEquals ( 'o',actual[2][2] );
    }

    @Test
    void drawScreen() {
    }

    @Test
    void drawLineInvalidParams() {
        Line line = new Line ( "10 10 1 4" );
        Exception exception = assertThrows (CommandException.InvalidCommandParamsException.class, () -> {
            paintScreen.drawLine ( line,'x' );
        } );
        assertTrue ( exception instanceof CommandException.InvalidCommandParamsException );
    }

    @Test
    void drawRectangleInvalidParams() {
        Rectangle rectangle = new Rectangle ( "1 1 10 10" );
        Exception exception = assertThrows (CommandException.InvalidCommandParamsException.class, () -> {
            paintScreen.drawRectangle ( rectangle,'x','x' );
        } );
        assertTrue ( exception instanceof CommandException.InvalidCommandParamsException );
    }

    @Test
    void addLineSuccess(){
        paintScreen.addLine ( new Line(1,2,6,2) );
        assertEquals ( 1,paintScreen.getLines ().size () );
    }

    @Test
    void addRectangleSuccess(){
        paintScreen.addRectangle ( new Rectangle (14,1,18,3) );
        assertEquals ( 1,paintScreen.getRectangles ().size () );
    }

    @Test
    @DisplayName ( "Fill Color on the Line" )
    void fillColorOnLineTestSuccess() throws CommandException.InvalidCommandParamsException {
        Canvas canvas = new Canvas ( "20 4" );
        Line line = new Line ( 1,2,6,2 );

        paintScreen = PaintScreen.getInstance (canvas);
        paintScreen.drawCanvas ( canvas,DrawingSymbol.CANVAS_HORIZONTAL_SYMBOL.getDrawingSymbol (),DrawingSymbol.CANVAS_VERTICAL_SYMBOL.getDrawingSymbol () );
        DrawLine drawLine = new DrawLine ( line );
        drawLine.execute ();
        paintScreen.fillColor ( new BucketFill ( 3,2,'o' ) );
        assertEquals ( 'o',paintScreen.getScreen ()[2][3] );
    }

    @Test
    @DisplayName ( "Fill Color on the Rectangle" )
    void fillColorOnRectangleTestSuccess() throws CommandException.InvalidCommandParamsException {
        Canvas canvas = new Canvas ( "20 4" );
        CreateCanvas createCanvas = new CreateCanvas ( canvas );
        createCanvas.execute ();
        paintScreen = PaintScreen.getInstance (canvas);
        Rectangle rectangle = new Rectangle ( 14,1,18,3 );
        DrawRectangle drawRectangle = new DrawRectangle ( rectangle );
        drawRectangle.execute ();
        BucketFill bucketFill = new BucketFill ( 16,2,'o' );
        BucketFillCommand bucketFillCommand = new BucketFillCommand ( bucketFill );
        bucketFillCommand.execute ();
        assertEquals ( 'o',paintScreen.getScreen ()[2][15] );
    }
}