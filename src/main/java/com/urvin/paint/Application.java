package com.urvin.paint;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ConsolePaint consolePaint = new ConsolePaint ();
        Scanner scanner = new Scanner ( System.in );
        String strCommand = null;
        while(true) {
            System.out.print ("Please Enter Paint Command:");
            strCommand = scanner.nextLine ();
            consolePaint.startDrawing (strCommand);
        }
    }
}
