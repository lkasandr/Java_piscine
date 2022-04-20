package ex02;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message)
    {
        System.out.println(message);
    }
}
