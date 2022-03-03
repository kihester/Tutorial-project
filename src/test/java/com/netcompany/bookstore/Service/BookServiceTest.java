package com.netcompany.bookstore.Service;


import com.netcompany.bookstore.dto.BookDto;
import com.netcompany.bookstore.model.Book;
import com.netcompany.bookstore.model.Genre;
import com.netcompany.bookstore.repository.BookRepository;
import com.netcompany.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    void findAllBookReturns() {
        Book newBook = new Book(12L,"HarryPotter", Genre.SCIFI, "J.K Rowling");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook));

        List<BookDto> result = bookService.findAll();

        assertEquals(result.size(),1);
        assertEquals(result.get(0).getName(),"HarryPotter");

    }
    @Test
    void findAllByGenre(){
        Book newBook1=new Book(13L,"book1",Genre.SCIFI, "Author1");
        Book newBook2=new Book(14L,"book2",Genre.ADVENTURE, "Author2");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook1,newBook2));
        List<BookDto> result = bookService.findByGenre("SCIFI");
        assertEquals(result.size(),1);
        assertEquals(result.get(0).getName(),"book1");
    }
    @Test
    void findAllByGenre_lowercase(){
        Book newBook1=new Book(13L,"book1",Genre.SCIFI, "Author1");
        Book newBook2=new Book(14L,"book2",Genre.ADVENTURE, "Author2");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook1,newBook2));
        List<BookDto> result = bookService.findByGenre("scifi");
        assertEquals(result.size(),1);
        assertEquals(result.get(0).getName(),"book1");
    }
    @Test
    void findAllByGenre_notInList(){
        Book newBook1=new Book(13L,"book1",Genre.SCIFI, "Author1");
        Book newBook2=new Book(14L,"book2",Genre.ADVENTURE, "Author2");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook1,newBook2));
        List<BookDto> result = bookService.findByGenre("FANTASY");
        assertTrue(result.isEmpty());
    }

    @Test
    void findAllByAuthor(){
        Book newBook1 = new Book(13L,"book1",Genre.SCIFI, "Author1");
        Book newBook2 = new Book(14L,"book2",Genre.ADVENTURE, "Author2");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook1,newBook2));
        List<BookDto> result = bookService.findByAuthor("Author2");
        assertEquals(result.size(),1);
        assertEquals(result.get(0).getAuthor(),"Author2");

    }

    @Test
    void findAllByAuthor_lowercase(){
        Book newBook1 = new Book(13L,"book1",Genre.SCIFI, "Author1");
        Book newBook2 = new Book(14L,"book2",Genre.ADVENTURE, "Author2");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook1,newBook2));
        List<BookDto> result = bookService.findByAuthor("author2");
        assertEquals(result.size(),1);
        assertEquals(result.get(0).getAuthor(),"Author2");

    }

    @Test
    void findAllByAuthor_notInList(){
        Book newBook1 = new Book(13L,"book1",Genre.SCIFI, "Author1");
        Book newBook2 = new Book(14L,"book2",Genre.ADVENTURE, "Author2");
        Mockito.when(bookRepository.findAll()).thenReturn(asList(newBook1,newBook2));
        List<BookDto> result = bookService.findByAuthor("Author3");
        assertTrue(result.isEmpty());

    }

}
