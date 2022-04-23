package edu.school21.printer.app;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;
import edu.school21.printer.logic.printPNG;

@Parameters(separators = "=")
public class Program {
    @Parameter(names={"--white"})
    String white;
    @Parameter(names={"--black"})
    String black;

    public static void main(String[] args){
        Program program = new Program();
        try {
            JCommander.newBuilder()
                    .addObject(program)
                    .build()
                    .parse(args);
        }
        catch (ParameterException e)
        {
            System.out.println("Invalid input");
        }
        program.run();
    }

    public void run() {
        printPNG picture = new printPNG(white, black);
        picture.print();
    }
}
