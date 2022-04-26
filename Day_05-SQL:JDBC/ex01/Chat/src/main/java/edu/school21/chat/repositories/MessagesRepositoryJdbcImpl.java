package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private HikariDataSource ds;
    private User user;
    private Chatroom room;
    private Message message;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds)
    {
        this.ds = ds;
    }

    public Optional<Message> findById(Long id) {
        Optional<Message> optionalMessage = null;
        try {
            Connection cM = ds.getConnection();
            Statement sM = cM.createStatement();
            ResultSet rsM = sM.executeQuery("SELECT * FROM \"Message\" WHERE messageid = " + id);
            rsM.next();
            setUser(rsM.getLong("userid"));
            setChatroom(rsM.getLong("roomid"));
            optionalMessage = Optional.of( new Message(
                    rsM.getLong("messageid"),
                    this.user,
                    this.room,
                    rsM.getString("textmessage"),
                    rsM.getTimestamp("datemessage").toLocalDateTime()));
            this.message = optionalMessage.get();
            printInfo();
            rsM.close();
            sM.close();
            cM.close();

        } catch (SQLException e) {
            System.out.println("No message");
        }
        return optionalMessage;
    }

    private void setUser(long id) throws SQLException
    {
        Connection cU = ds.getConnection();
        Statement sU = cU.createStatement();
        ResultSet rsU = sU.executeQuery("SELECT * FROM \"Users\" " + "WHERE userid = " + id);
        rsU.next();
        Optional<User> optionalUser = Optional.of(new User(
                rsU.getLong("userid"),
                rsU.getString("login"),
                rsU.getString("password")));
        this.user = optionalUser.get();
        rsU.close();
        sU.close();
        cU.close();
    }

    private void setChatroom(long id) throws SQLException
    {
        Connection cR = ds.getConnection();
        Statement sR = cR.createStatement();
        ResultSet rsR = sR.executeQuery("SELECT * FROM \"Chatroom\" " +
                "WHERE roomid = " + id);
        rsR.next();
        Optional<Chatroom> optionalChatroom = Optional.of( new Chatroom(
                rsR.getLong("roomid"),
                rsR.getString("roomname")));
        this.room = optionalChatroom.get();
        rsR.close();
        sR.close();
        cR.close();
    }

    private void printInfo()
    {
        System.out.println("Message: {");
        System.out.println("id: " + message.getId() + ",");
        System.out.println(user.toSting());
        System.out.println(room.toSting());
    }
}
