package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private Long userID;
    private String login;
    private String password;
    List<Chatroom> createdRooms = new ArrayList<>();
    List<Chatroom> rooms = new ArrayList<>();

    public User(Long userID, String login, String password, List<Chatroom> createdRooms, List<Chatroom> rooms) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.rooms = rooms;
    }

    public User(Long userid, String login, String password)
    {
        this.userID = userid;
        this.login = login;
        this.password = password;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getRooms() {
        return rooms;
    }

    public void setRooms(List<Chatroom> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                Objects.equals(createdRooms, user.createdRooms) &&
                Objects.equals(rooms, user.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, login, password, createdRooms, rooms);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", rooms=" + rooms +
                '}';
    }
}
