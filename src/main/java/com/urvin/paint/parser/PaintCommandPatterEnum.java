package com.urvin.paint.parser;

public enum PaintCommandPatterEnum {
    CANVAS("C w h"),
    LINE("L x1 y1 x2 y2"),
    RECTANGLE("R x1 y1 x2 y2"),
    BUCKET_FILL("B x y c"),
    QUIT("Q");

    private String commandPatternString;
    PaintCommandPatterEnum(String commandPatternString) {
        this.commandPatternString = commandPatternString;
    }
}
