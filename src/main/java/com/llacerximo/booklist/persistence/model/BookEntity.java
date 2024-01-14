package com.llacerximo.booklist.persistence.model;

import com.llacerximo.booklist.common.enums.GenreEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "books")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    PseudonymEntity pseudonymEntity;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    List<RereadEntity> rereadEntity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "books_genres",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    List<GenreEnum> genres;

//    @PreRemove
//    public void setAlgoToNull(){
//
//    }

}
