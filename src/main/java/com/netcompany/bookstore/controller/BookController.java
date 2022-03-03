package com.netcompany.bookstore.controller;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Book;
import com.netcompany.bookstore.model.Genre;
import com.netcompany.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/genre/{genre}")
    public List<BookDto> findByGenre(@PathVariable("genre")String genre){
        return bookService.findByGenre(genre);
    }

    @GetMapping("/author/{author}")
    public List<BookDto> findByAuthor(@PathVariable("author")String author){
        return bookService.findByAuthor(author);
    }

    @GetMapping("/save")
    public String saveNewData() {
        bookService.saveNewData();
        return "saved some new data";
    }
}
