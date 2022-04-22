package ex00;

public class Program {
    private static int count;

    public static void main(String[] args) throws InterruptedException {
        count = parseInput(args);

        Runnable printEgg = () -> {
            for (int i=0; i<count; ++i)
                System.out.println("Egg");
        };
        Runnable printHen = () -> {
            for (int i=0; i<count; ++i)
                System.out.println("Hen");
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

        for (int i=0; i<count; ++i)
            System.out.println("Human");
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
