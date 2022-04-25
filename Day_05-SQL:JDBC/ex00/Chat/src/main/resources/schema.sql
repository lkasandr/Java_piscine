CREATE TABLE "Users" (
    userID serial,
    login varchar NOT NULL,
    password varchar NOT NULL,
    createdRooms int[],
    rooms int[],
    PRIMARY KEY ( userID )
);

CREATE TABLE "Chatroom" (
    roomID serial,
    roomName varchar,
    ownerID int REFERENCES User (userID),
    message varchar,
    PRIMARY KEY ( roomID )
);

CREATE TABLE "Message" (
    messageID serial,
    userID int REFERENCES Users (userID),
    roomID int REFERENCES Chatroom (roomID),
    textMessage text,
    dateMessage date,
    PRIMARY KEY ( messageID )
);