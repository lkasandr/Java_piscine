CREATE TABLE Users (
    userID serial,
    login varchar NOT NULL,
    password varchar NOT NULL,
    createdRooms int[],
    rooms int[],
    PRIMARY KEY ( userID )
);

CREATE TABLE Chatroom (
    roomID serial,
    roomName varchar,
    ownerID int REFERENCES Users (userID),
    PRIMARY KEY ( roomID )
);

CREATE TABLE Message (
    messageID serial,
    userID int REFERENCES Users (userID),
    roomID int REFERENCES Chatroom (roomID),
    textMessage text,
    dateMessage timestamp,
    PRIMARY KEY ( messageID )
);