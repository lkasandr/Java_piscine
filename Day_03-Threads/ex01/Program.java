package ex01;

import static java.lang.Thread.sleep;

public class Program {
    private static int count;
    private static int isBusy;

    public static void main(String[] args) throws InterruptedException {
        count = parseInput(args);
        isBusy = 0;

        Runnable printEgg = () -> {
            for (int i=0; i<count; ++i) {
                while(isBusy == 1) {
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Egg");
                isBusy = 1;
            }
        };
        Runnable printHen = () -> {
            for (int i=0; i<count; ++i) {
                while(isBusy == 0) {
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Hen");
                isBusy = 0;
            }
        };

        Thread egg = new Thread(printEgg);
        Thread hen = new Thread(printHen);
        hen.start();
        egg.start();
        try {
            hen.join();
            egg.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("error in thread");
        }
    }

    private static void printInputError()
    {
        System.err.println("Invalid input");
        System.exit(-1);
    }

    private static int parseInput(String[] args)
    {
        int count = 0;
        if (args.length != 1) {
            printInputError();
        }
        String[] input = args[0].split("=");
        if (input.length != 2) {
            printInputError();
        }
        if (!input[0].equals("--count")) {
            printInputError();
        }
        try {
            count = Integer.parseInt(input[1]);
        }
        catch(Exception e) {
            printInputError();
        }
        if (count <= 0)
            printInputError();
        return count;
    }
}
