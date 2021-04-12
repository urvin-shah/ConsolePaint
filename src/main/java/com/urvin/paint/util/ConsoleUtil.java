package com.urvin.paint.util;

/**
 * This is Util class with utility methods.
 */
public class ConsoleUtil {

    /**
     * isNoNull verify the given input is null or not null.
     * @param input
     * @return
     */
    public static boolean isNotNull(String input) {
        if(input != null && !input.trim ().equalsIgnoreCase ( "" )) {
            return true;
        }
        return false;
    }

    /**
     * This returns the Commnad initial of the inputCommand.
     * @param inputCommand
     * @return
     */
    public static char getCommandInitial(String inputCommand) {
        if(isNotNull ( inputCommand )) {
            return Character.toUpperCase ( inputCommand.charAt ( 0 ));
        }
        return '0';
    }

    /**
     * getInt will returns the Integer value of the given string.
     * @param input
     * @return
     */
    public static Integer getInt(String input) {
        return Integer.valueOf ( input );
    }

    /**
     * getParamString will returns the parameters of the command.
     * @param input
     * @return
     */
    public static String getParamString(String input) {
        return input.substring ( 1 ).trim ();
    }
}
