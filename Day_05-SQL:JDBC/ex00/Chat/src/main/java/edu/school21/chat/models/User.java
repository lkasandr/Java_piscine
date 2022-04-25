package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private long userID;
    private String login;
    private String password;
    List<Chatroom> createdRooms;
    List<Chatroom> rooms;

    User(long userID, String login, String password, List<Chatroom> createdRooms, List<Chatroom> rooms)
    {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createdRooms, user.createdRooms) && Objects.equals(rooms, user.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, login, password, createdRooms, rooms);
    }

    public String toSting()
    {
        return ("USER INFO --> userID: " + userID +
                " login: " + login +
                " password: " + password +
                " createdRooms: " + createdRooms +
                " rooms: " + rooms);
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRooms(List<Chatroom> rooms) {
        this.rooms = rooms;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public List<Chatroom> getRooms() {
        return rooms;
    }
}
