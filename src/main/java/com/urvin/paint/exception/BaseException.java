package com.urvin.paint.exception;

public class BaseException extends Exception{
    private String message;
    private static final String ERROR_COLOR = "\033[0;31m";
    private static final String NORMAL_COLOR = "\033[0m";
    public BaseException(String msg) {
        this.message = msg;
    }

    public String getMessage() {return this.message;}

    public void printMessage() {
        System.out.println (ERROR_COLOR+this.message+NORMAL_COLOR);
    }
}
