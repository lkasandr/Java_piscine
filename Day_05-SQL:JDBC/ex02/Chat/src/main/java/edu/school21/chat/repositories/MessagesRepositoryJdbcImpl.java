package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
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

    @Override
    public void save(Message message)
    {
        String sql = "INSERT INTO chat.Message (userID, roomID, textMessage, dateMessage) VALUES (?, ?, ?,?)";
        try(Connection connection = ds.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, message.getAuthor().getUserID());
            stmt.setLong(2, message.getRoom().getRoomID());
            stmt.setString(3, message.getText());
            stmt.setDate(4, Date.valueOf(message.getDate().toLocalDate()));
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            {
                message.setId(generatedKeys.getLong(1));
            }
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        catch(NotSavedSubEntityException notSaveException)
        {
            System.out.println(notSaveException.getMessage());
        }
    }
}
