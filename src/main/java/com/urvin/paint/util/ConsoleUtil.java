package com.urvin.paint.util;

public class ConsoleUtil {
    public static boolean isNotNull(String input) {
        if(input != null && !input.trim ().equalsIgnoreCase ( "" )) {
            return true;
        }
        return false;
    }

    public static char getCommandInitial(String inputCommand) {
        if(isNotNull ( inputCommand )) {
            return Character.toUpperCase ( inputCommand.charAt ( 0 ));
        }
        return '0';
    }

    public static Integer getInt(String input) {
        return Integer.valueOf ( input );
    }

    public static String getParamString(String input) {
        return input.substring ( 1 ).trim ();
    }
}
