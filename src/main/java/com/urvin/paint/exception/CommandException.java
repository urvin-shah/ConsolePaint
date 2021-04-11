package com.urvin.paint.exception;

public class CommandException {
    public static class UnsupportedCommandException extends BaseException
    {
        private static final long serialVersionUID = 3555714415375055302L;
        public UnsupportedCommandException(String msg) {
            super(msg);
        }
    }

    public static class UnsupportedFormatException extends BaseException
    {
        private static final long serialVersionUID = 3555714415375055302L;
        public UnsupportedFormatException(String msg) {
            super(msg);
        }
    }

    public static class InvalidCommandParamsException extends BaseException
    {
        private static final long serialVersionUID = 3555714415375055302L;
        public InvalidCommandParamsException(String msg) {
            super(msg);
        }
    }
}
