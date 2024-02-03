package com.llacerximo.booklist.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "books")
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    Integer pages;
    @Column(name = "publish_year")
    Integer publishYear;
    @Column(name = "saga_num")
    Double sagaNum;
    Boolean fave;
    String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saga_id")
    SagaEntity sagaEntity;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    List<RereadEntity> rereadEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books_genres",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    List<GenreEntity> genreEntities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "authors_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    List<AuthorEntity> authorEntities;

//    @PreRemove
//    public void setAlgoToNull(){
//
//    }

}
