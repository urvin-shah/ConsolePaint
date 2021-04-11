package com.urvin.paint.parser;

import com.urvin.paint.constant.PaintCommandPatternEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaintCommandPatternTest {

    PaintCommandPattern paintCommandPattern;

    @Test
    @DisplayName ( "Canvas Pattern Success" )
    void matchCanvasSuccess() {
        paintCommandPattern = new PaintCommandPattern ( PaintCommandPatternEnum.CANVAS );
        assertTrue ( paintCommandPattern.match ( "C 20 20" ) );
        assertTrue ( paintCommandPattern.match ( "c 20 20" ) );
    }

    @Test
    @DisplayName ( "Line Pattern Success" )
    void matchLineSuccess() {
        paintCommandPattern = new PaintCommandPattern ( PaintCommandPatternEnum.LINE );
        assertTrue ( paintCommandPattern.match ( "L 20 5 20 25" ) );
        assertTrue ( paintCommandPattern.match ( "l 20 20 28 20" ) );
    }

    @Test
    @DisplayName ( "Rectangle Pattern Success" )
    void matchRectangleSuccess() {
        paintCommandPattern = new PaintCommandPattern ( PaintCommandPatternEnum.RECTANGLE );
        assertTrue ( paintCommandPattern.match ( "R 20 20 25 30" ) );
        assertTrue ( paintCommandPattern.match ( "r 20 20 28 28" ) );
    }

    @Test
    @DisplayName ( "Bucket Fill Pattern Success" )
    void matchBucketFillSuccess() {
        paintCommandPattern = new PaintCommandPattern ( PaintCommandPatternEnum.BUCKET_FILL );
        assertTrue ( paintCommandPattern.match ( "B 20 20 O" ) );
        assertTrue ( paintCommandPattern.match ( "b 20 20 O" ) );
    }
}