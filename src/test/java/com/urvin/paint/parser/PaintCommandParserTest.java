package com.urvin.paint.parser;

import com.urvin.paint.command.*;
import com.urvin.paint.exception.CommandException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PaintCommandParserTest {

    static PaintCommandParser paintCommandParser;

    @BeforeAll
    static void init() {
        paintCommandParser = PaintCommandParser.getInstance ();
    }

    @Test
    @DisplayName ( "parseCommand with Success" )
    void parseCommand() throws Exception{
        assertTrue ( this.paintCommandParser.parseCommand ( "C 20 30" ) instanceof CreateCanvas );
        assertTrue ( this.paintCommandParser.parseCommand ( "L 10 10 10 15" ) instanceof DrawLine );
        assertTrue ( this.paintCommandParser.parseCommand ( "R 2 2 9 9" ) instanceof DrawRectangle );
        assertTrue ( this.paintCommandParser.parseCommand ( "B 3 3 O" ) instanceof BucketFillCommand );
        assertTrue ( this.paintCommandParser.parseCommand ( "Q" ) instanceof QuitCommand );
    }

    @Test
    @DisplayName ( "parseCommand with UnsupportedCommand Exception" )
    void parseCommand_UnSupportedCommand() {
        Exception exception = assertThrows ( CommandException.UnsupportedCommandException.class, () -> {
            this.paintCommandParser.parseCommand ( " D 20 30" );
        });
        assertTrue (exception instanceof CommandException.UnsupportedCommandException);
    }

    @Test
    @DisplayName ( "parseCommand with UnsupportedFormat Exception" )
    void parseCommand_UnSupportedFormat() {
        Exception exception = assertThrows ( CommandException.UnsupportedFormatException.class, () -> {
            this.paintCommandParser.parseCommand ( "C 20 30 30" );
        });
        assertTrue (exception instanceof CommandException.UnsupportedFormatException);
    }
}