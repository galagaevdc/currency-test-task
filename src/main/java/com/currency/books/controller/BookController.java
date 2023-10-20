package com.currency.books.controller;

import com.currency.books.entity.BookDto;
import com.currency.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @PutMapping
    public BookDto update(@RequestBody BookDto bookDto) {
        return bookService.update(bookDto);
    }

    @GetMapping("/{id}")
    public BookDto update(@PathVariable long id) {
        return bookService.findById(id);
    }
}
