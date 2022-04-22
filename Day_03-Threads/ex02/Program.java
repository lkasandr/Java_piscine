package ex02;

public class Program {
    private static int sizeArray;
    private static int threadsCount;
    private static int[] array;

    public static void main(String[] args) throws InterruptedException {
        parseInput(args);
        randomFillingArray();
        createThreads();
    }

    private static void createThreads() throws InterruptedException
    {
        int firstIndex = 0;
        int lastIndex = 0;
        long sum = 0;
        for(int i = 0; i < threadsCount; ++i)
        {
            firstIndex = (sizeArray * i) / threadsCount;
            lastIndex = Math.min((sizeArray * (i + 1) / threadsCount), sizeArray) - 1;
            CalculateSum c = new CalculateSum(i, firstIndex, lastIndex, array);
            c.start();
            sum += c.getSum();
            try {
                c.join();
            }
            catch (InterruptedException e)
            {
                System.out.println("error in join");
            }
        }
        System.out.println("Sum by threads: " + sum);
    }

    private static void printInputError()
    {
        System.err.println("Invalid input");
        System.exit(-1);
    }

    private static void parseInput(String[] args)
    {
        if (args.length != 2) {
            printInputError();
        }
        String[] inputSize = args[0].split("=");
        String[] inputThreads = args[1].split("=");

        if (inputSize.length != 2 || inputThreads.length != 2) {
            printInputError();
        }
        if (!inputSize[0].equals("--arraySize") || !inputThreads[0].equals("--threadsCount")) {
            printInputError();
        }
        try {
            sizeArray = Integer.parseInt(inputSize[1]);
            threadsCount = Integer.parseInt(inputThreads[1]);
        }
        catch(Exception e) {
            printInputError();
        }
        if (sizeArray <= 0 || sizeArray > 2000000 || threadsCount <= 0 || threadsCount > sizeArray)
            printInputError();
    }

    private static void randomFillingArray()
    {
        long sum = 0;
        array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = ((int)(Math.random() * 2001) - 1000);
            sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }
}
