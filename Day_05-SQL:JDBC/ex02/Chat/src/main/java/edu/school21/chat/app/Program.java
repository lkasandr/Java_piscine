package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.MessagesRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("Dasha1234");

        User user = new User(1L, "hjkhjk", "1", new ArrayList<>(), new ArrayList<>());
        Chatroom chatroom = new Chatroom(1L, "chatroom", user, new ArrayList<>());
        Message message = new Message(null, user, chatroom, "razdvatri", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
        messagesRepository.save(message);
        System.out.println(message.getId());
        ds.close();
    }

}
