package ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.length() == 0)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        char[] charArray = str.toCharArray();
        int[] countOccur = new int[65535];
        for(int i = 0; i < 65535; ++i)
        {
            countOccur[i] = find_char(i, charArray, str);
            if (countOccur[i] > 999)
                countOccur[i] = 999;
        }
        int[][] topChar = getTopChar(countOccur);
        printRes(topChar);
    }

    static int find_char(int code, char[] charArray, String str)
    {
        int count = 0;
        for(int i = 0; i < str.length(); ++i)
        {
            if (code == (int) charArray[i])
                count++;
        }
        return count;
    }

    static int[][] getTopChar(int[] countOccur)
    {
        int[][] topChar = new int[10][2];

        topChar[0][1] = countOccur[0];
        for(int i = 1; i < 65535; ++i)
        {
            for(int j = 0; j < 10; ++j)
            {
                if (countOccur[i] > topChar[j][1])
                {
                    for(int k = 9; k > j; --k)
                    {
                        topChar[k][0] = topChar[k - 1][0];
                        topChar[k][1] = topChar[k - 1][1];
                    }
                    topChar[j][0] = i;
                    topChar[j][1] = countOccur[i];
                    break;
                }
                if (countOccur[i] != 0 && countOccur[i] == topChar[j][1])
                {
                    if (i < topChar[j][0])
                    {
                        for(int k = 9; k > j; --k)
                        {
                            topChar[k][0] = topChar[k - 1][0];
                            topChar[k][1] = topChar[k - 1][1];
                        }
                        topChar[j][0] = i;
                        topChar[j][1] = countOccur[i];
                        break;
                    }
                    else
                    {
                        j++;
                        for(int k = 9; k > j; --k)
                        {
                            topChar[k][0] = topChar[k - 1][0];
                            topChar[k][1] = topChar[k - 1][1];
                        }
                        topChar[j][0] = i;
                        topChar[j][1] = countOccur[i];
                        break;
                    }
                }
            }
        }
        return topChar;
    }

    static void printRes(int[][] topChar)
    {
        int[][] printArr = new int[12][10];

        for(int i = 0; i < 10; ++i)
        {
            int grid = topChar[i][1] * 10 / topChar[0][1];
            int j = 10;
            printArr[11][i] = topChar[i][0];
            while(grid > 0)
            {
                int k = 10 - grid;
                j = 10;
                while(j > k)
                {
                    printArr[j][i] = -1;
                    grid--;
                    j--;
                }
            }
            printArr[j][i] = topChar[i][1];
        }
        for(int i = 0; i < 11; ++i)
        {
            for(int j = 0; j < 10; ++j)
            {
                if (printArr[i][j] == -1)
                    System.out.print(" # ");
                else if (printArr[i][j] != 0 && printArr[i][j] != -1)
                    System.out.print(" " + printArr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 10; ++i)
        {
            if (printArr[11][i] != 0)
                System.out.print(" " + (char)printArr[11][i] + " ");
        }
    }
}
