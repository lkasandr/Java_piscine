package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private long roomID;
    private String roomName;
    private User owner;
    private List<Message> message;

    Chatroom(long id, String name, User owner, List<Message> message)
    {
        this.roomID = id;
        this.roomName = name;
        this.owner = owner;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return roomID == chatroom.roomID && Objects.equals(roomName, chatroom.roomName) && Objects.equals(owner, chatroom.owner) && Objects.equals(message, chatroom.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, roomName, owner, message);
    }


    public String toSting()
    {
        return ("CHATROOM INFO --> ID: " + roomID +
                " Name: " + roomName +
                " Owner: " + owner +
                " Messages: " + message);
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public long getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public User getOwner() {
        return owner;
    }

    public List<Message> getMessage() {
        return message;
    }
}
