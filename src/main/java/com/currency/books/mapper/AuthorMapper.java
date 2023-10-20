package com.currency.books.mapper;

import com.currency.books.dto.AuthorEntity;
import com.currency.books.dto.BookEntity;
import com.currency.books.entity.AuthorDto;
import com.currency.books.entity.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorEntity toDto(final AuthorEntity entity);
    AuthorEntity toEntity(final AuthorDto authorDto);
}
