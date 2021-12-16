CREATE TABLE book
(
    id      int(100)     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100) NOT NULL,
    author  VARCHAR(100) NOT NULL,
    year    INT(100)     NOT NULL,
    publish VARCHAR(100) NOT NULL,
    pages   INT(100)     NOT NULL
);