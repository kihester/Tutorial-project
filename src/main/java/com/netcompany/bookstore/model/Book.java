package com.netcompany.bookstore.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column
    private String author;

    public Book(String name, Genre genre, String author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }
}

