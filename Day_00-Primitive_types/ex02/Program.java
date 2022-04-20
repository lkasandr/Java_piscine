package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        int value = 0;
        int prime_number = 0;
        Scanner in = new Scanner(System.in);
        while(value != 42)
        {
            value = in.nextInt();
            if (checkPrime(value) == true)
                prime_number++;
        }
        System.out.println("Count of coffee-request - " + prime_number);
    }

    static int getSumNumber(int number)
    {
        int answer = 0;
        while(number != 0)
        {
            answer += number % 10;
            number = number / 10;
        }
        return answer;
    }

    static boolean checkPrime(int number)
    {
        int value = getSumNumber(number);
        int it = 2;
        if (value <= 0 || value == 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        while(it * it <= value)
        {
            if (value % it == 0)
                return false;
            it++;
        }
        return true;
    }
}
