package ex04;

public class UserExistException extends RuntimeException{
    UserExistException()
    {
        System.out.println("User is already exists");
    }
}
