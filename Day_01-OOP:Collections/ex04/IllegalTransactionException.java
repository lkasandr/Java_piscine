package ex04;

public class IllegalTransactionException extends RuntimeException{
    IllegalTransactionException()
    {
        System.out.println("Unable to complete transaction");
    }
}
