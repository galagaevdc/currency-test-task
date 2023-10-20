package com.currency.books.initilizer;

import com.currency.books.entity.BookDto;
import com.currency.books.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DbInitializer {
    @Autowired
    private BookService bookService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void initDatabase() throws IOException {
        final Page<BookDto> books = bookService.findAll(Pageable.ofSize(1));
        if (books.getTotalElements() == 0) {
            final List<BookDto> bookDtos = objectMapper.readValue(new ClassPathResource("catalog.json").getURL(),
                    new TypeReference<List<BookDto>>() {
                    });
            bookDtos.forEach(bookDto -> bookService.create(bookDto));
        }
    }
}
