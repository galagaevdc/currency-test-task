package com.currency.books.mapper;

import com.currency.books.dto.BookEntity;
import com.currency.books.entity.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(final BookEntity entity);
    List<BookDto> toDtos(final List<BookEntity> entity);
    BookEntity toEntity(final BookDto bookDto);
    void update(@MappingTarget BookEntity entity, BookDto updateDto);
}
