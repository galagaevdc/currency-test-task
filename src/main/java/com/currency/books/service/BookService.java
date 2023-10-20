package com.currency.books.service;

import com.currency.books.dto.AuthorEntity;
import com.currency.books.dto.BookEntity;
import com.currency.books.entity.AuthorDto;
import com.currency.books.entity.BookDto;
import com.currency.books.exception.BookNotFoundException;
import com.currency.books.mapper.AuthorMapper;
import com.currency.books.mapper.BookMapper;
import com.currency.books.repository.AuthorRepository;
import com.currency.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;


    public BookDto create(final BookDto book) {
        final List<AuthorEntity> authors = new ArrayList<>();
        for (final AuthorDto authorDto : book.getAuthors()) {
            final AuthorEntity authorEntity = authorRepository.findByEmail(authorDto.getEmail())
                    .orElseGet(() -> authorRepository.save(authorMapper.toEntity(authorDto)));
            authors.add(authorEntity);
        }
        final BookEntity bookEntity = bookMapper.toEntity(book);
        bookEntity.setAuthors(authors);
        final BookEntity savedBook = bookRepository.save(bookEntity);
        return bookMapper.toDto(savedBook);
    }

    public BookDto update(final BookDto book) {
        final BookEntity bookToUpdate = getBook(book.getId());
        final List<AuthorEntity> authors = new ArrayList<>();
        for (final AuthorDto authorDto : book.getAuthors()) {
            final AuthorEntity authorEntity = authorRepository.findByEmail(authorDto.getEmail())
                    .orElseGet(() -> authorRepository.save(authorMapper.toEntity(authorDto)));
            authors.add(authorEntity);
        }
        bookToUpdate.setAuthors(authors);
        bookMapper.update(bookToUpdate, book);
        final BookEntity savedBook = bookRepository.save(bookToUpdate);
        return bookMapper.toDto(savedBook);
    }

    private BookEntity getBook(final Long id) {
        return bookRepository.findById(id).orElseThrow(() -> {
            throw new BookNotFoundException("Unable to find book " + id);
        });
    }

    public BookDto findById(final Long id) {
        return bookMapper.toDto(getBook(id));
    }

    public Page<BookDto> findAll(final Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toDto);
    }

}
