package com.netcompany.bookstore.mapper;

import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    public static BookDto mapToDto(Book book) {
        return new BookDto(book.getName(), book.getAuthor());
    }

}
