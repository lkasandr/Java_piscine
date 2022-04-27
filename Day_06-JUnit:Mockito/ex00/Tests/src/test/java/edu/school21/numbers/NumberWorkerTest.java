package edu.school21.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 11, 101, 19, 383, 997})
    @DisplayName("JUnit5 - Prime numbers")
    void isPrimeForPrimes(int number)
    {
        NumberWorker nw = new NumberWorker();
        boolean prime = nw.isPrime(number);
        assertTrue(prime);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 15, 169, 500, 3830, 1002})
    @DisplayName("JUnit5 - Composite numbers")
    void isPrimeForNotPrimes(int number)
    {
        NumberWorker nw = new NumberWorker();
        boolean prime = nw.isPrime(number);
        assertFalse(prime);
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, -6, 0, 1, -500, -3830, -1002, Integer.MIN_VALUE})
    @DisplayName("JUnit5 - Incorrect numbers")
    void isPrimeForIncorrectNumbers(int number) throws NumberWorker.IllegalNumberException
    {
        NumberWorker nw = new NumberWorker();
        assertThrows(NumberWorker.IllegalNumberException.class, () -> nw.isPrime(number));
    }

    @ParameterizedTest
    @DisplayName("JUnit5 - Digits sum")
    @CsvFileSource(resources = "/data.csv")
    void testDigitsSum(int sentence, int expected)
    {
        NumberWorker nw = new NumberWorker();
        int digitSum = nw.digitsSum(sentence);
        assertEquals(expected, digitSum);
    }

}
