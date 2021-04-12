package com.urvin.paint.constant;


/**
 * This Enum keeps the patterns of various console paint commands.
 */
public enum PaintCommandPatternEnum {
    CANVAS("[Cc]{1} [0-9]{1,3} [0-9]{1,3}"),
    LINE("[Ll]{1} [0-9]{1,3} [0-9]{1,3} [0-9]{1,3} [0-9]{1,3}"),
    RECTANGLE("[Rr]{1} [0-9]{1,3} [0-9]{1,3} [0-9]{1,3} [0-9]{1,3}"),
    BUCKET_FILL("[Bb]{1} [0-9]{1,3} [0-9]{1,3} [A-Za-z]"),
    QUIT("[Qq]{1}");

    private String commandPatternString;

    /**
     * Constructor with patten.
     * @param commandPatternString
     */
    PaintCommandPatternEnum(String commandPatternString) {
        this.commandPatternString = commandPatternString;
    }

    /**
     * This method will return the command pattern string of a given Enum.
     * @return
     */
    public String getCommandPatternString() {
        return commandPatternString;
    }
}
