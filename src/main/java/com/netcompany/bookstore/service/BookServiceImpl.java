package com.netcompany.bookstore.service;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.mapper.BookMapper;
import com.netcompany.bookstore.model.Author;
import com.netcompany.bookstore.model.Book;
import com.netcompany.bookstore.model.Genre;
import com.netcompany.bookstore.repository.BookRepository;
import com.netcompany.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.netcompany.bookstore.model.Genre.fromText;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

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
    public List<BookDto> findByAuthor(String author){
        List<BookDto> booksFoundDto = new ArrayList<>();

        List<Book> booksFound = bookRepository.findByAuthor(author);

        for (Book b : booksFound) {
            booksFoundDto.add(bookMapper.mapToDto(b));
        }

        return booksFoundDto;
    }

    @Override
    public BookDto addNewBook(BookDto book) {

        Optional<Author> optionalAuthor = authorRepository.findAuthorByFirstNameAndLastName(book.getAuthorFirstName(), book.getAuthorLastName());

        if(optionalAuthor.isPresent()){
            Book savedBook = bookRepository.save(bookMapper.mapToModel(book, optionalAuthor.get()));
            return bookMapper.mapToDto(savedBook);
        }

        Author newAuthor = authorRepository.save(new Author(book.getAuthorFirstName(), book.getAuthorLastName(), book.getAuthorAge()));

        Book savedBook = bookRepository.save(bookMapper.mapToModel(book, newAuthor));
        return bookMapper.mapToDto(savedBook);
    }



    @Override
    public void saveNewData() {
        Book book = new Book();
        book.setName("kieran");
        bookRepository.save(book);
    }
}
