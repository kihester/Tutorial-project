
CREATE TABLE author (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    firstName varchar(255) NOT NULL,
    lastName varchar(255) NOT NULL,
    age int(10) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE book (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    genre ENUM('ADVENTURE','SCIFI','FICTION') NOT NULL ,
    author_id bigint(20) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author(id),
    PRIMARY KEY (`id`)

);
