package ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int orderWeek = 1;
        long grade = 0;
        long dogNail = 1;
        while(orderWeek <= 18)
        {
            String week = in.next();
            if (week.equals("42"))
                break;
            if (!week.equals("Week"))
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int weekNumber = in.nextInt();
            if (orderWeek != weekNumber)
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            grade += getGrade(in) * dogNail;
            dogNail = dogNail * 10;
            orderWeek++;
        }
        printResult(grade);
    }

    static int getGrade(Scanner in)
    {
        int grade = 0;
        int minGrade = 9;
        for(int i = 0; i < 5; ++i)
        {
            grade = in.nextInt();
            if (grade < 1 || grade > 9)
            {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            if (grade < minGrade)
                minGrade = grade;
        }
        return minGrade;
    }

    static void printResult(long grade)
    {
        long minGrade = 0;
        int weekOrder = 1;
        while(grade != 0)
        {
            System.out.print("Week ");
            System.out.print(weekOrder);
            System.out.print(" ");
            minGrade = grade % 10;
            while(minGrade > 0)
            {
                System.out.print("=");
                minGrade--;
            }
            System.out.println(">");
            weekOrder++;
            grade = grade / 10;
        }
    }
}
