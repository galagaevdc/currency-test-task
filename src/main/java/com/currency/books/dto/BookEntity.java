package com.currency.books.dto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "isbn")
    private String isbn;
    @ManyToMany
    private List<AuthorEntity> authors;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "genre", nullable = false)
    private List<String> genres;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "publish_date")
    private Date publishDate;
    @Column(name = "publisher")
    private String publisher;
}
