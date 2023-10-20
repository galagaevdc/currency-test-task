package com.currency.books.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String title;
    @NotBlank(message = "Isbn is mandatory")
    private String isbn;
    private List<AuthorDto> authors;
    private List<String> genres;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("publish_date")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publishDate;
    private String publisher;
}
