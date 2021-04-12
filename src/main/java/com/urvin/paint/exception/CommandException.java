package com.urvin.paint.exception;

/**
 * This is the CommandException class for the Commands
 */
public class CommandException {

    /**
     * This Exception can be used when Command which is entered not supported by the application
     */
    public static class UnsupportedCommandException extends BaseException
    {
        private static final long serialVersionUID = 3555714415375055302L;
        public UnsupportedCommandException(String msg) {
            super(msg);
        }
    }

    /**
     * This Exception class can be used when command is supported but the command text
     * message is not matching with the CommandPattern
     */
    public static class UnsupportedFormatException extends BaseException
    {
        private static final long serialVersionUID = 3555714415375055302L;
        public UnsupportedFormatException(String msg) {
            super(msg);
        }
    }

    /**
     * This Exception class can be used when command is supported and the command text
     * message is also matching with the CommandPattern but the parameters are not valid.
     */
    public static class InvalidCommandParamsException extends BaseException
    {
        private static final long serialVersionUID = 3555714415375055302L;
        public InvalidCommandParamsException(String msg) {
            super(msg);
        }
    }
}
