package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long roomID;
    private String roomName;
    private User owner;
    private List<Message> message = new ArrayList<>();

    public Chatroom(Long roomID, String roomName, User owner, List<Message> message) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.owner = owner;
        this.message = message;
    }

    public Chatroom(Long roomid, String roomname)
    {
        this.roomID = roomid;
        this.roomName = roomname;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return roomID == chatroom.roomID &&
                roomName.equals(chatroom.roomName) &&
                owner.equals(chatroom.owner) &&
                Objects.equals(message, chatroom.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, roomName, owner, message);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "roomID=" + roomID +
                ", roomName='" + roomName + '\'' +
                ", owner=" + owner +
                ", message=" + message +
                '}';
    }
}
