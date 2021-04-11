package com.urvin.paint.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleUtilTest {

    @Test
    void isNotNullSuccess() {
        assertTrue ( ConsoleUtil.isNotNull ( "ConsolePaint" ) );
    }

    @Test
    void isNotNullFailure() {
        assertFalse ( ConsoleUtil.isNotNull ( " " ));
    }

    @Test
    void isNotNullWithNull_Failure() {
        assertFalse ( ConsoleUtil.isNotNull ( null ));
    }

    @Test
    void getCommandInitial() {
        assertEquals ('C', ConsoleUtil.getCommandInitial ( "C 20 20" ) );
        assertEquals ('C', ConsoleUtil.getCommandInitial ( "c 20 20" ) );

        assertEquals ('L', ConsoleUtil.getCommandInitial ( "L 20 20 20 25" ) );
        assertEquals ('L', ConsoleUtil.getCommandInitial ( "l 20 20 20 25" ) );

        assertEquals ('R', ConsoleUtil.getCommandInitial ( "R 20 20 30 30" ) );
        assertEquals ('R', ConsoleUtil.getCommandInitial ( "r 20 20 30 30" ) );

        assertEquals ('B', ConsoleUtil.getCommandInitial ( "B 20 20 )" ) );
        assertEquals ('B', ConsoleUtil.getCommandInitial ( "b 20 20 O" ) );

        assertEquals ('Q', ConsoleUtil.getCommandInitial ( "Q" ) );
        assertEquals ('Q', ConsoleUtil.getCommandInitial ( "q" ) );

        assertEquals ('C', ConsoleUtil.getCommandInitial ( "C 20 20" ) );
        assertEquals ('C', ConsoleUtil.getCommandInitial ( "c 20 20" ) );
    }

    @Test
    void getCommandInitial_Failure() {
        assertEquals ( '0', ConsoleUtil.getCommandInitial ( null ) );
    }
}