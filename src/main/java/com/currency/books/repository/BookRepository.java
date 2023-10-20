package com.currency.books.repository;

import com.currency.books.dto.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long>, CrudRepository<BookEntity, Long> {
}
