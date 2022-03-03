package com.netcompany.bookstore.mapper;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Author;
import com.netcompany.bookstore.model.Book;
import org.springframework.stereotype.Component;

import static com.netcompany.bookstore.model.Genre.fromText;

@Component
public class BookMapper {


    public static BookDto mapToDto(Book book) {
        return new BookDto(book.getName(), book.getAuthor().getFirstName(),book.getAuthor().getLastName(),book.getAuthor().getAge(), book.getGenre().getDisplayName());
    }

    public Book mapToModel(BookDto book) {
        return new Book(book.getName(),fromText(book.getGenre()).get(), new Author(book.getAuthorFirstName(), book.getAuthorLastName(), book.getAuthorAge()));
    }
}
