CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE if not exists chat.Users (
    userID serial unique,
    login varchar NOT NULL,
    password varchar NOT NULL,
    createdRooms int[],
    rooms int[],
    PRIMARY KEY ( userID )
);

CREATE TABLE if not exists chat.Chatroom (
    roomID serial unique,
    roomName varchar,
    ownerID int REFERENCES Users (userID),
    PRIMARY KEY ( roomID )
);

CREATE TABLE if not exists chat.Message (
    messageID serial unique,
    userID int REFERENCES Users (userID),
    roomID int REFERENCES Chatroom (roomID),
    textMessage text,
    dateMessage timestamp,
    PRIMARY KEY ( messageID )
);