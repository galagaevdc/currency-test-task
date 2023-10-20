package com.currency.books.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Book is not found")
public class BookNotFoundException extends RuntimeException {
}
