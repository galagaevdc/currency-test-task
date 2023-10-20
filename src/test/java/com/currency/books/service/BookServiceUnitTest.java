package com.currency.books.service;

import com.currency.books.exception.BookNotFoundException;
import com.currency.books.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    public void getBookWhenNotExistShouldThrowException() {
        BookNotFoundException bookNotFoundException = Assertions.assertThrows(BookNotFoundException.class,
                () -> bookService.findById(4L));


        assertEquals(bookNotFoundException.getMessage(), "Unable to find book 4");
    }

    //TODO: Add unit tests for other cases
}
