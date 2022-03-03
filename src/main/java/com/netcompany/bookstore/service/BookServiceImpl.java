package com.netcompany.bookstore.service;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.mapper.BookMapper;
import com.netcompany.bookstore.model.Book;
import com.netcompany.bookstore.model.Genre;
import com.netcompany.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.netcompany.bookstore.model.Genre.fromText;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(BookMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<BookDto> findByGenre(String genre){
        Optional<Genre> optionalGenre= fromText(genre);
        if (optionalGenre.isPresent()){
            return bookRepository.findAll().stream().filter(book -> book.getGenre().equals(optionalGenre.get()))
                    .map(BookMapper::mapToDto)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public void saveNewData() {
        Book book = new Book();
        book.setName("kieran");
        bookRepository.save(book);
    }
}
