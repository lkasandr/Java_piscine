package edu.school21.printer.app;


import edu.school21.printer.logic.printPNG;

public class Program {
    private static char white;
    private static char black;
    private static String path;

    public static void main(String[] args){
        parseInput(args);
        printPNG picture = new printPNG(white, black, path);
        picture.print();
    }

    private static void printErrorInput()
    {
        System.err.println("Invalid input");
        System.exit(-1);
    }

    private static void parseInput(String[] args){
        if (args.length != 3)
            printErrorInput();
        if (args[0].length() != 1 || args[1].length() != 1)
            printErrorInput();
        white = args[0].charAt(0);
        black = args[1].charAt(0);
        path = args[2];
    }
}
