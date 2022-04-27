DROP TABLE IF EXISTS Product;

CREATE TABLE Product (
    identifier  INT PRIMARY KEY IDENTITY,
    name        VARCHAR(1000) NOT NULL,
    price       INT
);