package com.urvin.paint.parser;

import com.urvin.paint.command.IPaintCommand;
import com.urvin.paint.constant.PaintCommandPatternEnum;

public class PaintCommandPattern {
    private PaintCommandPatternEnum pattern;

    public PaintCommandPattern(PaintCommandPatternEnum pattern) {
        this.pattern = pattern;
    }

    public PaintCommandPatternEnum getPattern() {
        return pattern;
    }

    public boolean match(String input) {
        return input.trim ().matches ( this.pattern.getCommandPatternString () );
    }
}
