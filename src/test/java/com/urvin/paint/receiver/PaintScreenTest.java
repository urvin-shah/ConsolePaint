package com.urvin.paint.receiver;

import com.urvin.paint.command.BucketFillCommand;
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
}