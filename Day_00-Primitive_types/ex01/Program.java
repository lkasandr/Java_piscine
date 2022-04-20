package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        int it = 2;
        if (value <= 0 || value == 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        while(it * it <= value)
        {
            if (value % it == 0)
            {
                System.out.println("false " + (it - 1));
                System.exit(0);
            }
            it++;
        }
        System.out.println("true " + (it - 1));
        System.exit(0);
    }
}
