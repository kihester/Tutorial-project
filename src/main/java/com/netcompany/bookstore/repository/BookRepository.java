package com.netcompany.bookstore.repository;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

}
