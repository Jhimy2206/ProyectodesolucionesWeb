package com.books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBook;

    @Column(nullable = false, length = 13, unique = true)
    private String isbn;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @Column(nullable = false)
    private LocalDate publishDate;

    @Column(nullable = false)
    private Integer copiesTotal;

    @Column(nullable = false)
    private Integer copiesAvailable;

    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false,
            foreignKey = @ForeignKey(name = "FK_BOOK_AUTHOR"))
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false,
            foreignKey = @ForeignKey(name = "FK_BOOK_EDITORIAL"))
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false,
            foreignKey = @ForeignKey(name = "FK_BOOK_CATEGORY"))
    private Category category;





}
