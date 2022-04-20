package ex00;

public class Program {
    public static void main(String[] args)
    {
        int value = 123456;
        int answer = 0;

        answer = value % 10;
        value = value / 10;
        answer += value % 10;
        value = value / 10;
        answer += value % 10;
        value = value / 10;
        answer += value % 10;
        value = value / 10;
        answer += value % 10;
        value = value / 10;
        answer += value % 10;
        value = value / 10;
        answer += value % 10;

        System.out.println(answer);
    }
}
