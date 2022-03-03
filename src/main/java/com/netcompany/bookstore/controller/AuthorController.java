package com.netcompany.bookstore.controller;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Author;
import com.netcompany.bookstore.service.AuthorService;
import com.netcompany.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public List<Author> findAll() {
        return authorService.findAll();
    }

}
