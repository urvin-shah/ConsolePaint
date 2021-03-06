package com.urvin.paint.exception;

/**
 * This is the Custom Parent Exception class.
 */
public class BaseException extends Exception{
    private String message;
    private static final String ERROR_COLOR = "\033[0;31m";
    private static final String NORMAL_COLOR = "\033[0m";
    public BaseException(String msg) {
        this.message = msg;
    }

    /**
     * This method will return the exception message.
     * @return
     */
    public String getMessage() {return this.message;}

    /**
     * This method can be called to print the message of exception extending the BaseException
     */
    public void printMessage() {
        System.out.println (ERROR_COLOR+this.message+NORMAL_COLOR);
    }
}
