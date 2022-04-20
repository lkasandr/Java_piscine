package ex04;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException()
    {
        System.out.println("User not found");
    }
}
