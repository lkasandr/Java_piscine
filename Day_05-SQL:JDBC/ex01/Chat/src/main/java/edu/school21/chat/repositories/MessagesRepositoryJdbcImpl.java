package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private HikariDataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds)
    {
        this.ds = ds;
    }

    public Optional<Message> findById(Long id)
    {
        Optional<Message> optionalMessage = Optional.empty();

        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat.Message WHERE messageID = " + id);
            if (!resultSet.next())
                return Optional.of(new Message(0L, null, null, "message", null));
            String text = resultSet.getString("textMessage");
            Timestamp time = resultSet.getTimestamp("dateMessage");
            Long userID = resultSet.getLong("userID");
            Long roomID = resultSet.getLong("roomID");
            resultSet = statement.executeQuery("SELECT * FROM chat.Users WHERE userID = " + userID);
            resultSet.next();

            User user = new User(userID,
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    null,
                    null);

            resultSet = statement.executeQuery("SELECT * FROM chat.Chatroom WHERE roomID = " + roomID);
            resultSet.next();
            Chatroom room = new Chatroom(roomID,
                    resultSet.getString("roomName"),
                    null,
                    null);
            optionalMessage = Optional.of(new Message(id, user, room, text, time.toLocalDateTime()));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return optionalMessage;
    }
}
