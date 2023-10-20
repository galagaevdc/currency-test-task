package com.currency.books.repository;

import com.currency.books.dto.AuthorEntity;
import com.currency.books.dto.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByEmail(final String email);
}
