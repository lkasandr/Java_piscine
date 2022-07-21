package ex01;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static java.lang.Math.sqrt;

public class Program {
    private static List<String> fileA= new ArrayList<>();
    private static List<String> fileB = new ArrayList<>();
    private static TreeSet<String> dictionary = new TreeSet<>();

    private static List<String> parseFile(String path)
    {
        List<String> temp = new ArrayList<>();
        File file = new File(path);
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            if (((double) file.length() / 1024 / 1024) > 10)
            {
                System.out.println("Maximum size of these files is 10 MB!");
                System.exit(1);
            }
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                temp.addAll(Arrays.asList(line.split(" ")));
            }
            if (temp.isEmpty())
            {
                System.out.println("Empty file!");
                System.exit(1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    private static void writeDictionaryToFile()
    {
        try(BufferedWriter pw = new BufferedWriter(new FileWriter(new File("dictionary.txt"))))
        {
            for(String str : dictionary)
            {
                pw.write(str + " ");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static long[] getVector(List<String> file)
    {
        long[] vector = new long[dictionary.size()];
        int pos = 0;
        for(String word : dictionary)
        {
            long occurrence = 0;
            for(String words : file)
            {
                if (word.equals(words))
                  occurrence++;
            }
            vector[pos] = occurrence;
            pos++;
        }
        return vector;
    }

    private static void calculateFrequency(long[] vectorA, long[] vectorB)
    {
        long numerator = calculateNumerator(vectorA, vectorB);
        double denominator = calculateDenominator(vectorA, vectorB);
        double similarity = numerator / denominator;

        MathContext context = new MathContext(2, RoundingMode.FLOOR);
        BigDecimal result = new BigDecimal(similarity, context);

        System.out.println("Similarity = " + result);
    }

    private static double calculateDenominator(long[] vectorA, long[] vectorB)
    {
        double denominator = 0;
        long sumA = calculateSumVector(vectorA);
        long sumB = calculateSumVector(vectorB);
        denominator = sqrt(sumA) * sqrt(sumB);
        return denominator;
    }

    private static long calculateSumVector(long[] vector)
    {
        long sum = 0;
        for(long i : vector)
        {
            sum += i * i;
        }
        return sum;
    }

    private static long calculateNumerator(long[] vectorA, long[] vectorB)
    {
        long numerator = 0;
        for(int i = 0; i < vectorA.length; ++i)
        {
            numerator += vectorA[i] * vectorB[i];
        }
        return  numerator;
    }

    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Invalid arguments!");
            System.exit(1);
        }
        fileA = parseFile(args[0]);
        fileB = parseFile(args[1]);
        dictionary.addAll(fileA);
        dictionary.addAll(fileB);
        writeDictionaryToFile();
        long[] vectorA = getVector(fileA);
        long[] vectorB = getVector(fileB);
        calculateFrequency(vectorA, vectorB);
    }
}
