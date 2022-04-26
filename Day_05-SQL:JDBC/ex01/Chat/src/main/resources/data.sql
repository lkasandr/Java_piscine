INSERT INTO "Users" ( login, password, createdrooms, rooms )
VALUES  ('user1','user1', '{1}', '{1, 2, 3, 4}'),
        ('user2','user2', '{2}', '{1, 2, 3}'),
        ('user3','user3', '{3}', '{3, 2}'),
        ('user4','user4', '{4}', '{4}'),
        ('user5','user5', '{5}', '{5}');

INSERT INTO "Chatroom" ( roomName, ownerID, messageID)
VALUES ('general', 1, '{1}'),
       ('random', 2, '{2}'),
       ('born-to-code', 3, '{3}'),
       ('random', 4, '{4}'),
       ('general', 5, '{5}');

INSERT INTO "Message" (userID, roomID, textMessage, dateMessage)
VALUES (1, 1, 'hello, I''m user1!', '1999-01-08 04:05:06'),
       (2, 2, 'hello, I''m user2!', '1999-02-08 05:15:06'),
       (3, 3, 'hello, I''m user3!', '1999-03-08 08:23:16'),
       (4, 2, 'hello, I''m user4!', '1999-02-08 05:10:00'),
       (5, 1, 'hello, I''m user5!', '1999-01-08 04:05:10');