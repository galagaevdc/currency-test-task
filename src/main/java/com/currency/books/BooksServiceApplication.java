package com.currency.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class BooksServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksServiceApplication.class, args);
    }
}
