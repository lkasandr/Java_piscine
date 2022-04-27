package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        int it = 2;
        if (number <= 0 || number == 1)
            throw new IllegalNumberException();
        while(it * it <= number)
        {
            if (number % it == 0)
                return false;
            it++;
        }
        return true;
    }

    public int digitsSum(int number) {
        int res = 0;
        if (number < 0)
            number = number * (-1);
        while(number != 0)
        {
            res += number % 10;
            number = number / 10;
        }
        return res;
    }

    public class IllegalNumberException extends RuntimeException {
        IllegalNumberException() {
            System.out.println("Wrong number");
        }
    }
}
