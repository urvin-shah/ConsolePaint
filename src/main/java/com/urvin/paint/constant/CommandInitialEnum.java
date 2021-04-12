package com.urvin.paint.constant;

import com.urvin.paint.exception.BaseException;
import com.urvin.paint.exception.CommandException;

import java.util.Arrays;

/**
 * CommandInitialEunm is a constant which has initial command details
 */
public enum CommandInitialEnum {
    C,
    R,
    L,
    B,
    Q;

    /**
     * This method provide the CommandInitialEnum against the initial Char.
     * @param initial
     * @return
     */
    public static CommandInitialEnum getCommandInitialEnum(char initial)  {
        return Arrays.stream( CommandInitialEnum.values () ).filter ( in-> in.toString ().charAt ( 0 ) == initial ).findFirst ().orElse ( null );
    }
}
