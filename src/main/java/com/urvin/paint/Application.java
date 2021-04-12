package com.urvin.paint;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ConsolePaint consolePaint = new ConsolePaint ();
        Scanner scanner = new Scanner ( System.in );
        String strCommand = null;
        StringBuilder sbWelcome = new StringBuilder("Welcome to Console Application !!!");
        sbWelcome.append(System.lineSeparator())
            .append("Please apply below Commands :").append(System.lineSeparator())
            .append("1. C w h  : To Create a new canvas of width w and height h. |").append(System.lineSeparator())
            .append("2. L x1 y1 x2 y2 : To draw a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines Horizontal and vertical lines will be drawn using the 'x' character.").append(System.lineSeparator())
            .append("3. R x1 y1 x2 y2 : To draw a new rectangle, whose upper left corner is (x1,y1) and lower right corner and vertical lines will be drawn using the 'x' character. ").append(System.lineSeparator())
            .append("4. B x y c : To fill the entire area connected to (x,y) with \"colour\" c. The behaviour of this is the \"bucket fill\" tool in paint programs.").append(System.lineSeparator())
            .append("5. Q To quit the program.").append(System.lineSeparator());

        System.out.println(sbWelcome.toString());

        while(true) {
            System.out.print ("Please Enter Paint Command:");
            strCommand = scanner.nextLine ();
            consolePaint.startDrawing (strCommand);
            System.out.println ();
        }
    }
}
