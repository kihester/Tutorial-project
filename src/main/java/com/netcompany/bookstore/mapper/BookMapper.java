package com.netcompany.bookstore.mapper;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Book;
import org.springframework.stereotype.Component;

import static com.netcompany.bookstore.model.Genre.fromText;

@Component
public class BookMapper {


    public static BookDto mapToDto(Book book) {
        return new BookDto(book.getName(), book.getGenre().getText(), book.getAuthor());
    }

    public Book mapToModel(BookDto book) {
        return new Book(book.getName(), fromText(book.getGenre()).get(), book.getAuthor());
    }
}
