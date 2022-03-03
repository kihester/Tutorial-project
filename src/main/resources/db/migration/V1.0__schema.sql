CREATE TABLE book (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    genre ENUM('ADVENTURE','SCIFI','FICTION') NOT NULL ,
    author varchar(255) NOT NULL,
    PRIMARY KEY (`id`)

);