package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        long messageID = 0;
        String str;
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("Dasha1234");

        MessagesRepository mr = new MessagesRepositoryJdbcImpl(ds);

        while(true)
        {
            System.out.println("Enter a message ID");
            Scanner in = new Scanner(System.in);
            if (in.hasNextLong())
            {
                messageID = in.nextLong();
                mr.findById(messageID);
            }
            else
            {
                str = in.next();
                if (str.equals("exit"))
                    break;
                else
                    System.out.println("Invalid input");
            }
        }
    }
}
