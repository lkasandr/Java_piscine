package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.MessagesRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("Dasha1234");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
        User user = new User(1L, "qwerty", "qwerty", new ArrayList<>(), new ArrayList<>());
        Chatroom chatroom = new Chatroom(1L, "yuiop", user, null);
        messagesRepository.save(new Message(1L, user, chatroom, "message", LocalDateTime.now()));
        Optional<Message> messageOptional = messagesRepository.findById(1L);
        if (messageOptional.isPresent())
        {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDate(null);
            messagesRepository.update(message);
            System.out.println(message);
        }
        ds.close();
    }

}
